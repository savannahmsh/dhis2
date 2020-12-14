/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.dhisconnector.api.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.annotation.Generated;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
		"indicator",
		"dataElement",
		"comboOption"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class DHISMappingElement {

	@JsonProperty("indicator")
	private String indicator;

	@JsonProperty("dataElement")
	private String dataElement;

	@JsonProperty("comboOption")
	private String comboOption;

	/**
	 * @return The indicator
	 */
	@JsonProperty("indicator")
	public String getIndicator() {
		return indicator;
	}

	/**
	 * @param indicator The indicator
	 */
	@JsonProperty("indicator")
	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	/**
	 * @return The dataElement
	 */
	@JsonProperty("dataElement")
	public String getDataElement() {
		return dataElement;
	}

	/**
	 * @param dataElement The dataElement
	 */
	@JsonProperty("dataElement")
	public void setDataElement(String dataElement) {
		this.dataElement = dataElement;
	}

	/**
	 * @return The comboOption
	 */
	@JsonProperty("comboOption")
	public String getComboOption() {
		return comboOption;
	}

	/**
	 * @param comboOption The comboOption
	 */
	@JsonProperty("comboOption")
	public void setComboOption(String comboOption) {
		this.comboOption = comboOption;
	}

}
