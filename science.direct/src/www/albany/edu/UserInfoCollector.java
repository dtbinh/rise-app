package www.albany.edu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;
import net.htmlparser.jericho.Source;
import www.iese.edu.PageSource;
import www.iese.edu.User;

import com.data.generator.extractor.HtmlExtractor;
import com.data.generator.util.Precondition;

public class UserInfoCollector {
	private final HtmlExtractor htmlExtractor;
	private final PageSource pageSource;

	public UserInfoCollector(HtmlExtractor argHtmlExtractor) {
		super();
		this.htmlExtractor = argHtmlExtractor;
		this.pageSource = new PageSource();
	}

	public HtmlExtractor getHtmlExtractor() {
		return this.htmlExtractor;
	}

	public PageSource getPageSource() {
		return this.pageSource;
	}

	public List<User> getUserInfoList(Map<String, String> argNameVsEmailUrlMap) {
		@SuppressWarnings("unchecked")
		Map<String, String> nameVsEmailUrlMap = (Map<String, String>) Precondition
				.ensureNotEmpty(argNameVsEmailUrlMap, "Name Vs Email URL Map");
		Iterator<Entry<String, String>> iterator = nameVsEmailUrlMap.entrySet()
				.iterator();
		List<User> usersList = new ArrayList<User>();
		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			String name = entry.getKey();
			String emailUrl = entry.getValue();
			List<String> emailsList = getEmails(emailUrl);
			if (/*Precondition.checkNotEmpty(emailsList)
					&& */Precondition.checkNotEmpty(name)) {
				User user = new User();
				user.setName(name);
				user.setEmailsList(emailsList);
				usersList.add(user);
			}
		}
		return usersList;
	}

	private List<String> getEmails(String argEmailUrl) {
		List<String> emailsList = new ArrayList<String>();
		if (Precondition.checkNotEmpty(argEmailUrl)) {
			String emailUrl = argEmailUrl;
			String emailContent = this.getPageSource().getHtmlContent(emailUrl);
			if (Precondition.checkNotEmpty(emailContent)) {
				Source source = this.getHtmlExtractor()
						.getSourceBasedOnHtmlString(emailContent);
				if (Precondition.checkNotNull(source)) {
					Element element = source.getFirstElementByClass("intro");
					if (Precondition.checkNotNull(element)) {
						List<Element> emailElementsList = element
								.getAllElements(HTMLElementName.A);
						if (Precondition.checkNotEmpty(emailElementsList)) {
							for (Element anchorTagElement : emailElementsList) {
								String attributeValue = anchorTagElement
										.getAttributeValue("href");
								if (Precondition.checkNotEmpty(attributeValue)
										&& attributeValue.startsWith("mailto:")) {
									attributeValue = attributeValue.replaceAll(
											"mailto:", "");
									emailsList.add(attributeValue);
								}
							}
						}
					}
				}
			}
		}
		return emailsList;
//		return null;
	}
}
