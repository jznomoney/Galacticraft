package micdoodle8.mods.galacticraft.mars.client.gui;

import micdoodle8.mods.galacticraft.API.ISchematicResultPage;
import micdoodle8.mods.galacticraft.API.SchematicRegistry;
import micdoodle8.mods.galacticraft.mars.inventory.GCMarsContainerRocketBenchT2;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GCMarsGuiSchematicRocketT2 extends GuiContainer implements ISchematicResultPage
{
    private GuiButton backButton;
    private GuiButton nextButton;
    private int pageIndex;

    public GCMarsGuiSchematicRocketT2(InventoryPlayer par1InventoryPlayer, int x, int y, int z)
    {
        super(new GCMarsContainerRocketBenchT2(par1InventoryPlayer, x, y, z));
        this.ySize = 238;
    }

    @Override
    public void initGui()
    {
        super.initGui();
        this.buttonList.clear();
        this.buttonList.add(this.backButton = new GuiButton(0, this.width / 2 - 130, this.height / 2 - 30 + 27, 40, 20, "Back"));
        this.buttonList.add(this.nextButton = new GuiButton(1, this.width / 2 + 90, this.height / 2 - 30 + 27, 40, 20, "Next"));
    }

    @Override
    protected void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.enabled)
        {
            switch (par1GuiButton.id)
            {
            case 0:
                SchematicRegistry.flipToLastPage(this.pageIndex);
                break;
            case 1:
                SchematicRegistry.flipToNextPage(this.pageIndex);
                break;
            }
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        this.fontRenderer.drawString("Tier 2 Rocket", 7, -20 + 27, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, 220 - 104 + 2 + 27, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture("/mods/galacticraftmars/textures/gui/schematic_rocket_T2.png");
        final int var5 = (this.width - this.xSize) / 2;
        final int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
    }

    @Override
    public void setPageIndex(int index)
    {
        this.pageIndex = index;
    }
}
