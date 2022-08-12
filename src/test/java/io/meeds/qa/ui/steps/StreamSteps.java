package io.meeds.qa.ui.steps;

import io.meeds.qa.ui.pages.page.factory.Social.StreamPage;

public class StreamSteps {
	private StreamPage streamPage;

	public void hoverSpaceName(String spaceName) {
		streamPage.hoverSpaceName(spaceName);
	}

	public void hoverUserName(String user) {
		streamPage.hoveruserName(user);
	}
}
