package com.rise.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rise.common.model.Person;
import com.rise.common.util.constants.HibernateConstants;
import com.rise.service.BaseService;
import com.rise.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController extends BaseController {
	
	@Autowired
	private PersonService personService;

	@RequestMapping(value = HibernateConstants.CREATE, method = RequestMethod.GET)
	public String get(Model argModel) {
		argModel.addAttribute(getSimpleName(), new Person());
		return HibernateConstants.VIEW_SLASH + getSimpleName()
				+ HibernateConstants.NEW;
	}
	@RequestMapping(value = HibernateConstants.PERSON_CREATE, method = RequestMethod.GET)
	public String create(Model argModel) {
		argModel.addAttribute(getSimpleName(), new Person());
		return HibernateConstants.VIEW_SLASH + getSimpleName()
				+ HibernateConstants.PERSON;
	}
	@RequestMapping(value = HibernateConstants.LIST)
	public String listPersonNames(Model argModel) {
		List<com.rise.common.model.Model> persons = this.getBaseService().findAll();
		argModel.addAttribute(getSimpleName(), new Person());
		argModel.addAttribute(getFullyQualifiedName(), persons);
		return HibernateConstants.VIEW_SLASH + getSimpleName()
				+ HibernateConstants.LIST;
	}

	@RequestMapping(value = HibernateConstants.EDIT, method = RequestMethod.GET)
	public String editPerson(Model argModel, Person argPerson) {
		Person person = (Person) this.getBaseService().findById(argPerson.getId());
		argModel.addAttribute(HibernateConstants.EDIT_PERSON, person);
		argModel.addAttribute(HibernateConstants.EDIT_MODE, true);
		return HibernateConstants.VIEW_SLASH + getSimpleName()
				+ HibernateConstants.EDIT;
	}

	@RequestMapping(value = HibernateConstants.DELETE
			+ HibernateConstants.PATH_VARIABLE_ID, method = RequestMethod.GET)
	public String deletePerson(@PathVariable("argId") int argId) {
		if (argId != -1) {
			this.getBaseService().deleteById(argId);
			return HibernateConstants.RE_DIRECT + HibernateConstants.SLASH
					+ getSimpleName() + HibernateConstants.LIST;
		}
		return HibernateConstants.ERROR;
	}

	@RequestMapping(value = HibernateConstants.SAVE, method = RequestMethod.POST)
	public String save(Model argModel, @Validated Person argPerson) {
		Person person = (Person) this.getBaseService().save(argPerson);
		argModel.addAttribute(getSimpleName(), person);
		return HibernateConstants.VIEW_SLASH + getSimpleName()
				+ HibernateConstants.VIEW;
	}

	@RequestMapping(value = HibernateConstants.UPDATE, method = RequestMethod.POST)
	public String update(Model argModel, @Validated Person argPerson) {
		Person person = (Person) this.getBaseService().update(argPerson);
		argModel.addAttribute(getSimpleName(), person);
		return HibernateConstants.VIEW_SLASH + getSimpleName()
				+ HibernateConstants.VIEW;
	}

	@RequestMapping(value = HibernateConstants.PATH_VARIABLE_ID, method = RequestMethod.GET)
	public String getPerson(@PathVariable String argId, Model argModel) {
		if (argId != null && !argId.isEmpty() && argModel != null) {
			Person person = (Person) this.getBaseService().findById(Integer
					.parseInt(argId));
			argModel.addAttribute(getSimpleName(), person);
			return HibernateConstants.VIEW_SLASH + getSimpleName()
					+ HibernateConstants.VIEW;
		}
		return HibernateConstants.ERROR;
	}

	@Override
	public BaseService getBaseService() {
		return this.personService;
	}

}