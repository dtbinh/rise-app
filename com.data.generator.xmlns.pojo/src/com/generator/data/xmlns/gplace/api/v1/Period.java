//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.10 at 04:38:34 PM IST 
//


package com.generator.data.xmlns.gplace.api.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Period complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Period">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="open" type="{http://xmlns.data.generator.com/gplace/api/v1}Open" minOccurs="0"/>
 *         &lt;element name="close" type="{http://xmlns.data.generator.com/gplace/api/v1}Close" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Period", propOrder = {
    "open",
    "close"
})
public class Period {

    protected Open open;
    protected Close close;

    /**
     * Gets the value of the open property.
     * 
     * @return
     *     possible object is
     *     {@link Open }
     *     
     */
    public Open getOpen() {
        return open;
    }

    /**
     * Sets the value of the open property.
     * 
     * @param value
     *     allowed object is
     *     {@link Open }
     *     
     */
    public void setOpen(Open value) {
        this.open = value;
    }

    /**
     * Gets the value of the close property.
     * 
     * @return
     *     possible object is
     *     {@link Close }
     *     
     */
    public Close getClose() {
        return close;
    }

    /**
     * Sets the value of the close property.
     * 
     * @param value
     *     allowed object is
     *     {@link Close }
     *     
     */
    public void setClose(Close value) {
        this.close = value;
    }

}