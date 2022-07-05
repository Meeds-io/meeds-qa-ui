package steps;

import pages.page.factory.administration.ManageDomainsPage;

public class ManageDomainsSteps {

  private ManageDomainsPage manageDomainsPage;

  public void goToManageDomainMenu() {
    manageDomainsPage.goToManageDomainMenu();
  }

  public void addDomain(String name, String description) {
    manageDomainsPage.addDomain();
    manageDomainsPage.fillForm(name, description);
  }

  public void confirmDomain() {
    manageDomainsPage.confirmDomain();
  }

  public void isDomainNameDisplayedInSearchResults(String domainName) {
    manageDomainsPage.insertDomainNameInSearchField(domainName);
    manageDomainsPage.checkTheDomainNameDisplay(domainName);
  }

  public void editDomainName(String name) {
    manageDomainsPage.editDomainName(name);
  }

  public void deleteDomain() {
    manageDomainsPage.deleteDomain();
  }

  public void confirmDomainDeletion() {
    manageDomainsPage.confirmDomainDeletion();
  }

  public void domainNameIsNotDisplayed(String domainName) {
    manageDomainsPage.insertDomainNameInSearchField(domainName);
    manageDomainsPage.domainNameIsNotDisplayed(domainName);
  }

  public void goToAdministration() {
    manageDomainsPage.goToAdministration();
  }

  public void goToAutomaticTranslation() {
    manageDomainsPage.goToAutomaticTranslation();
  }

  public void checkTitlePageAutomaticTranslation(String title) {
    manageDomainsPage.checkTitlePageAutomaticTranslation(title);
  }

  public void checkAlertPublishingActivity(String alert) {
    manageDomainsPage.checkTitlePageAutomaticTranslation(alert);
  }

  public void searchDomain(String domainName) {
    manageDomainsPage.insertDomainNameInSearchField(domainName);
  }

  public void searchedDomainNameDisplayed(String domainName) {
    manageDomainsPage.checkTheDomainNameDisplay(domainName);
  }

}
