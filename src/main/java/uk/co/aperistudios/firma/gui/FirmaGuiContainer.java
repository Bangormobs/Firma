package uk.co.aperistudios.firma.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public abstract class FirmaGuiContainer extends GuiContainer {
	boolean drawInventory=false;
	protected ResourceLocation tex;
	
	@Override
	public void initGui() {
		super.initGui();
		guiLeft = (width - xSize) / 2;
		guiTop = (height - ySize) / 2;
	}
	
	public FirmaGuiContainer(Container cont, int w, int h) {
		super(cont);
		xSize = w;
		ySize = h;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int x, int y) {
		drawGui(tex);
	}
	

	protected void drawGui(ResourceLocation rl)
	{
		if (rl != null)
		{
			this.mc.getTextureManager().bindTexture(rl);
			guiLeft = (width - xSize) / 2;
			guiTop = (height - ySize) / 2;
			int height = drawInventory ? this.getShiftedYSize() : ySize;

			drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, height);

			drawForeground(guiLeft, guiTop);
		}
		//if (drawInventory){
		//	PlayerInventory.drawInventory(this, width, height, this.getShiftedYSize());
		//}
	}
	
	public abstract void drawForeground(int let, int top);
	

	protected int getShiftedYSize()
	{
		return this.ySize ;//- PlayerInventory.invYSize;
	}

}