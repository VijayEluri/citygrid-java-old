/*
 * Licensed to Lolay, Inc. under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  Lolay, Inc. licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://github.com/lolay/citygrid/raw/master/LICENSE
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */
package com.lolay.citygrid.content.places.detail;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lolay.citygrid.BaseInvoker;
import com.lolay.citygrid.Format;
import com.lolay.citygrid.InvokerException;

/**
 * @see http://docs.citygridmedia.com/display/citygridv2/Places+API#PlacesAPI-PlacesDetail
 * @see DetailClient
 */
public class DetailInvoker extends BaseInvoker {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(DetailInvoker.class);
	
	private Long warningLimit = 10000L;
	private Integer listingId = null;
	private Integer infoUsaId = null;
	private String phone = null;
	private String publisher = null;
	private String apiKey = null;
	private Boolean customerOnly = null;
	private Boolean allResults = null;
	private Integer reviewCount = null;
	private String placement = null;
	private String clientIp = null;
	
	public Long getWarningLimit() {
		return warningLimit;
	}
	public void setWarningLimit(Long warningLimit) {
		this.warningLimit = warningLimit;
	}
	public Integer getListingId() {
		return listingId;
	}
	public void setListingId(Integer listingId) {
		this.listingId = listingId;
	}
	public Integer getInfoUsaId() {
		return infoUsaId;
	}
	public void setInfoUsaId(Integer infoUsaId) {
		this.infoUsaId = infoUsaId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public Boolean getCustomerOnly() {
		return customerOnly;
	}
	public void setCustomerOnly(Boolean customerOnly) {
		this.customerOnly = customerOnly;
	}
	public Boolean getAllResults() {
		return allResults;
	}
	public void setAllResults(Boolean allResults) {
		this.allResults = allResults;
	}
	public Integer getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
	}
	public String getPlacement() {
		return placement;
	}
	public void setPlacement(String placement) {
		this.placement = placement;
	}
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	public DetailResults profile(DetailClient client) throws InvokerException {
		DetailResults results;
		
		Long start = System.currentTimeMillis();

		results = parseResults(DetailResults.class, client.profile(getListingId(), getInfoUsaId(),
			getPhone(), getPublisher(), getApiKey(), getCustomerOnly(), getAllResults(),
			getReviewCount(), getPlacement(), getClientIp(), Format.XML));
		
		Long end = System.currentTimeMillis();
		Long diff = end - start;
		
		if (log.isTraceEnabled()) {
			log.trace(String.format("CityGrid profile took %s milliseconds", diff));
		} else if (log.isWarnEnabled() && diff > getWarningLimit()) {
			log.warn(String.format("CityGrid profile took %s milliseconds which is longer than the threshold %s milliseconds", diff, getWarningLimit()));
		}
		
		return results;
	}
	
	public static Builder builder(DetailInvoker prototype) {
		return builder().listingId(prototype.getListingId()).infoUsaId(prototype.getInfoUsaId())
			.phone(prototype.getPhone()).publisher(prototype.getPublisher())
			.apiKey(prototype.getApiKey()).customerOnly(prototype.getCustomerOnly())
			.allResults(prototype.getAllResults()).reviewCount(prototype.getReviewCount())
			.placement(prototype.getPlacement()).clientIp(prototype.getClientIp());
	}
	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder implements Serializable {
		private static final long serialVersionUID = 1L;

		private DetailInvoker instance = new DetailInvoker();
		private Builder() { }
		
		public Builder warningLimit(Long warningLimit) {
			instance.setWarningLimit(warningLimit);
			return this;
		}
		
		public Builder listingId(Integer listingId) {
			instance.setListingId(listingId);
			return this;
		}
		
		public Builder infoUsaId(Integer infoUsaId) {
			instance.setInfoUsaId(infoUsaId);
			return this;
		}
		
		public Builder phone(String phone) {
			instance.setPhone(phone);
			return this;
		}
		
		public Builder publisher(String publisher) {
			instance.setPublisher(publisher);
			return this;
		}
		
		public Builder apiKey(String apiKey) {
			instance.setApiKey(apiKey);
			return this;
		}
		
		public Builder customerOnly(Boolean customerOnly) {
			instance.setCustomerOnly(customerOnly);
			return this;
		}
		
		public Builder allResults(Boolean allResults) {
			instance.setAllResults(allResults);
			return this;
		}
		
		public Builder reviewCount(Integer reviewCount) {
			instance.setReviewCount(reviewCount);
			return this;
		}
		
		public Builder placement(String placement) {
			instance.setPlacement(placement);
			return this;
		}
		
		public Builder clientIp(String clientIp) {
			instance.setClientIp(clientIp);
			return this;
		}
		
		public DetailInvoker build() {
			return instance;
		}
	}
}