package uk.co.aperistudios.firma.items;

public class ScrapMetalItem extends MetaItem {

	public ScrapMetalItem(String name) {
		super(name);
		setSubs(new String[] { "copper", "tin", "bismuth", "bronze", "bismuthbronze", "blackbronze", "brass", "silver", "gold", "rosegold", "copper", "lead",
				"nickel", "platinum", "wroughtiron", "pigiron", "steel", "sterlingsilver", "zinc", "blacksteel", "redsteel", "bluesteel", "unknown" });
	}

}
