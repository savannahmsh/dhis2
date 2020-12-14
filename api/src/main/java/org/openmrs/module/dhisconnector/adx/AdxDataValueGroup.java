package org.openmrs.module.dhisconnector.adx;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Java class for groupType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class. <pre>
 * &lt;complexType name="groupType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;element name="dataValue" type="{urn:ihe:qrph:adx:2015}dataValueType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="orgUnit" use="required" type="{http://www.w3.org/2001/XMLSchema}token" />
 *       &lt;attribute name="period" use="required" type="{urn:ihe:qrph:adx:2015}periodType" />
 *       &lt;anyAttribute processContents='skip'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "groupType", propOrder = { "dataValue" })
public class AdxDataValueGroup {
	
	
	@XmlElement(required = true)
	protected List<AdxDataValue> dataValue;
	
	@XmlAttribute(name = "dataSet", required = true)
	protected String dataSet;
	
	//TODO evaluate this to AdxDataValueGroupPeriod#period to evaluate as a string
	@XmlAttribute(name = "period", required = true)
	@XmlJavaTypeAdapter(AdxDataValueGroupPeriodAdapter.class)
	protected AdxDataValueGroupPeriod period;
	
	@XmlAttribute(name = "orgUnit", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlSchemaType(name = "token")
	protected String orgUnit;
	
	@XmlAttribute(name = "completeDate", required = false)
	protected String completeDate;
	
	public AdxDataValueGroup() {
	}
	
	public AdxDataValueGroup(AdxDataValue dataValue, AdxDataValueGroupPeriod period, String orgUnit, String dataSet) {
		setDataSet(dataSet);
		getDataValues().add(dataValue);
		setPeriod(period);
		setOrgUnit(orgUnit);
	}
	
	@XmlAnyAttribute
	private Map<QName, String> otherAttributes = new HashMap<QName, String>();
	
	/**
	 * Gets the value of the dataValue property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the dataValue property.
	 * <p>
	 * For example, to add a new item, do as follows: <pre>
	 *    getDataValue().add(newItem);
	 * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link AdxDataValue }
	 */
	public List<AdxDataValue> getDataValues() {
		if (dataValue == null) {
			dataValue = new ArrayList<AdxDataValue>();
		}
		return this.dataValue;
	}
	
	/**
	 * Gets the value of the orgUnit property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getOrgUnit() {
		return orgUnit;
	}
	
	/**
	 * Sets the value of the orgUnit property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setOrgUnit(String value) {
		this.orgUnit = value;
	}
	
	/**
	 * Gets the value of the period property.
	 * 
	 * @return possible object is {@link String }
	 */
	public AdxDataValueGroupPeriod getPeriod() {
		return period;
	}
	
	/**
	 * Sets the value of the period property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPeriod(AdxDataValueGroupPeriod value) {
		this.period = value;
	}
	
	/**
	 * Gets a map that contains attributes that aren't bound to any typed property on this class.
	 * <p>
	 * the map is keyed by the name of the attribute and the value is the string value of the
	 * attribute. the map returned by this method is live, and you can add new attribute by updating
	 * the map directly. Because of this design, there's no setter.
	 * 
	 * @return always non-null
	 */
	public Map<QName, String> getOtherAttributes() {
		return otherAttributes;
	}
	
	public String getDataSet() {
		return dataSet;
	}
	
	public void setDataSet(String dataSet) {
		this.dataSet = dataSet;
	}
	
	public String getCompleteDate() {
		return completeDate;
	}
	
	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}
	
}
