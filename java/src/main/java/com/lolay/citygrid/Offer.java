package com.lolay.citygrid;

import java.io.Serializable;
import java.net.URI;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@XmlRootElement(name="offer")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class Offer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="offer_name",required=true)
	private String offerName = null;
	@XmlElement(name="offer_text",required=true)
	private String offerText = null;
	@XmlElement(name="offer_description",required=true)
	private String offerDescription = null;
	@XmlElement(name="offer_url",required=true)
	private URI offerUrl = null;
	@XmlElement(name="offer_expiration_date")
	@XmlJavaTypeAdapter(value=DateAdapter.class)
	private Date offerExpirationDate = null;
	
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public String getOfferText() {
		return offerText;
	}
	public void setOfferText(String offerText) {
		this.offerText = offerText;
	}
	public String getOfferDescription() {
		return offerDescription;
	}
	public void setOfferDescription(String offerDescription) {
		this.offerDescription = offerDescription;
	}
	public URI getOfferUrl() {
		return offerUrl;
	}
	public void setOfferUrl(URI offerUrl) {
		this.offerUrl = offerUrl;
	}
	public Date getOfferExpirationDate() {
		return offerExpirationDate;
	}
	public void setOfferExpirationDate(Date offerExpirationDate) {
		this.offerExpirationDate = offerExpirationDate;
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	@Override
	public boolean equals(Object obj) {
	   return EqualsBuilder.reflectionEquals(this, obj);
	}
	@Override
	public String toString() {
	   return ToStringBuilder.reflectionToString(this);
	}
}