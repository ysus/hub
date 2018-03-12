package com.playful.loyalty.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FrontTags {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String tbRegister;
	private String tbRegisterText;
	private String tbLogin;
	
	private String tsRegister;
	private String tsLogin;
	private String tsVideo;
	
	private String aboutTitle;
	private String aboutDescription;
	private String aoutFooter;
	
	private String pfAviso;
	private String pfAvisoLink;
	private String pfTerms;
	private String pfTermsLink;
	private String pfHelp;
	private String pfHelpLink;
	
	private String tfLocal;
	private String tfLocalLink;
	private String tfRepublica;
	private String tfRepublicaLink;
	private String tfLoyalty;
	private String tfLoyaltyLink;
	
	private String sfTwitter;
	private String sfFacebook;
	private String sfYoutube;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTbRegister() {
		return tbRegister;
	}
	public void setTbRegister(String tbRegister) {
		this.tbRegister = tbRegister;
	}
	public String getTbRegisterText() {
		return tbRegisterText;
	}
	public void setTbRegisterText(String tbRegisterText) {
		this.tbRegisterText = tbRegisterText;
	}
	public String getTbLogin() {
		return tbLogin;
	}
	public void setTbLogin(String tbLogin) {
		this.tbLogin = tbLogin;
	}
	public String getTsRegister() {
		return tsRegister;
	}
	public void setTsRegister(String tsRegister) {
		this.tsRegister = tsRegister;
	}
	public String getTsLogin() {
		return tsLogin;
	}
	public void setTsLogin(String tsLogin) {
		this.tsLogin = tsLogin;
	}
	public String getTsVideo() {
		return tsVideo;
	}
	public void setTsVideo(String tsVideo) {
		this.tsVideo = tsVideo;
	}
	public String getAboutTitle() {
		return aboutTitle;
	}
	public void setAboutTitle(String aboutTitle) {
		this.aboutTitle = aboutTitle;
	}
	public String getAboutDescription() {
		return aboutDescription;
	}
	public void setAboutDescription(String aboutDescription) {
		this.aboutDescription = aboutDescription;
	}
	public String getAoutFooter() {
		return aoutFooter;
	}
	public void setAoutFooter(String aoutFooter) {
		this.aoutFooter = aoutFooter;
	}
	public String getPfAviso() {
		return pfAviso;
	}
	public void setPfAviso(String pfAviso) {
		this.pfAviso = pfAviso;
	}
	public String getPfAvisoLink() {
		return pfAvisoLink;
	}
	public void setPfAvisoLink(String pfAvisoLink) {
		this.pfAvisoLink = pfAvisoLink;
	}
	public String getPfTerms() {
		return pfTerms;
	}
	public void setPfTerms(String pfTerms) {
		this.pfTerms = pfTerms;
	}
	public String getPfTermsLink() {
		return pfTermsLink;
	}
	public void setPfTermsLink(String pfTermsLink) {
		this.pfTermsLink = pfTermsLink;
	}
	public String getPfHelp() {
		return pfHelp;
	}
	public void setPfHelp(String pfHelp) {
		this.pfHelp = pfHelp;
	}
	public String getPfHelpLink() {
		return pfHelpLink;
	}
	public void setPfHelpLink(String pfHelpLink) {
		this.pfHelpLink = pfHelpLink;
	}
	public String getTfLocal() {
		return tfLocal;
	}
	public void setTfLocal(String tfLocal) {
		this.tfLocal = tfLocal;
	}
	public String getTfLocalLink() {
		return tfLocalLink;
	}
	public void setTfLocalLink(String tfLocalLink) {
		this.tfLocalLink = tfLocalLink;
	}
	public String getTfRepublica() {
		return tfRepublica;
	}
	public void setTfRepublica(String tfRepublica) {
		this.tfRepublica = tfRepublica;
	}
	public String getTfRepublicaLink() {
		return tfRepublicaLink;
	}
	public void setTfRepublicaLink(String tfRepublicaLink) {
		this.tfRepublicaLink = tfRepublicaLink;
	}
	public String getTfLoyalty() {
		return tfLoyalty;
	}
	public void setTfLoyalty(String tfLoyalty) {
		this.tfLoyalty = tfLoyalty;
	}
	public String getTfLoyaltyLink() {
		return tfLoyaltyLink;
	}
	public void setTfLoyaltyLink(String tfLoyaltyLink) {
		this.tfLoyaltyLink = tfLoyaltyLink;
	}
	public String getSfTwitter() {
		return sfTwitter;
	}
	public void setSfTwitter(String sfTwitter) {
		this.sfTwitter = sfTwitter;
	}
	public String getSfFacebook() {
		return sfFacebook;
	}
	public void setSfFacebook(String sfFacebook) {
		this.sfFacebook = sfFacebook;
	}
	public String getSfYoutube() {
		return sfYoutube;
	}
	public void setSfYoutube(String sfYoutube) {
		this.sfYoutube = sfYoutube;
	}


}

	
