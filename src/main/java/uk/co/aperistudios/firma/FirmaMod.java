package uk.co.aperistudios.firma;

import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import uk.co.aperistudios.firma.blocks.CrucibleBlock;
import uk.co.aperistudios.firma.blocks.OreBlock;
import uk.co.aperistudios.firma.blocks.ShitOnFloor;
import uk.co.aperistudios.firma.blocks.boring.BaseBlock;
import uk.co.aperistudios.firma.blocks.boring.BrickBlock;
import uk.co.aperistudios.firma.blocks.boring.BrickBlock2;
import uk.co.aperistudios.firma.blocks.boring.ClayBlock;
import uk.co.aperistudios.firma.blocks.boring.ClayBlock2;
import uk.co.aperistudios.firma.blocks.boring.CobbleBlock;
import uk.co.aperistudios.firma.blocks.boring.CobbleBlock2;
import uk.co.aperistudios.firma.blocks.boring.DirtBlock;
import uk.co.aperistudios.firma.blocks.boring.DirtBlock2;
import uk.co.aperistudios.firma.blocks.boring.GravelBlock;
import uk.co.aperistudios.firma.blocks.boring.GravelBlock2;
import uk.co.aperistudios.firma.blocks.boring.IceBlock;
import uk.co.aperistudios.firma.blocks.boring.PlankBlock;
import uk.co.aperistudios.firma.blocks.boring.PlankBlock2;
import uk.co.aperistudios.firma.blocks.boring.RockBlock;
import uk.co.aperistudios.firma.blocks.boring.RockBlock2;
import uk.co.aperistudios.firma.blocks.boring.SandBlock;
import uk.co.aperistudios.firma.blocks.boring.SandBlock2;
import uk.co.aperistudios.firma.blocks.boring.SmoothBlock;
import uk.co.aperistudios.firma.blocks.boring.SmoothBlock2;
import uk.co.aperistudios.firma.blocks.liquids.BaseLiquid;
import uk.co.aperistudios.firma.blocks.living.GrassBlock;
import uk.co.aperistudios.firma.blocks.living.GrassBlock2;
import uk.co.aperistudios.firma.blocks.living.LeafBlock;
import uk.co.aperistudios.firma.blocks.living.LeafBlock2;
import uk.co.aperistudios.firma.blocks.living.LogBlock;
import uk.co.aperistudios.firma.blocks.living.LogBlock2;
import uk.co.aperistudios.firma.blocks.living.SaplingBlock;
import uk.co.aperistudios.firma.blocks.living.SaplingBlock2;
import uk.co.aperistudios.firma.blocks.living.SparseGrassBlock;
import uk.co.aperistudios.firma.blocks.living.SparseGrassBlock2;
import uk.co.aperistudios.firma.blocks.machine.AnvilBlock;
import uk.co.aperistudios.firma.crafting.CraftingManager;
import uk.co.aperistudios.firma.items.BrickItem;
import uk.co.aperistudios.firma.items.ClayItem;
import uk.co.aperistudios.firma.items.DoubleIngotItem;
import uk.co.aperistudios.firma.items.FirmaItem;
import uk.co.aperistudios.firma.items.GemItem;
import uk.co.aperistudios.firma.items.HideItem;
import uk.co.aperistudios.firma.items.IngotItem;
import uk.co.aperistudios.firma.items.ToolHeads;
import uk.co.aperistudios.firma.items.MetalSheetItem;
import uk.co.aperistudios.firma.items.OreItem;
import uk.co.aperistudios.firma.items.PebbleItem;
import uk.co.aperistudios.firma.items.ScrapMetalItem;
import uk.co.aperistudios.firma.items.ToolItem;
import uk.co.aperistudios.firma.items.UnfiredClay;

@Mod(modid = FirmaMod.MODID, version = FirmaMod.VERSION)
public class FirmaMod {
	@Instance
	public static FirmaMod instance;
	@SidedProxy(clientSide = "uk.co.aperistudios.firma.ClientProxy", serverSide = "uk.co.aperistudios.firma.ServerProxy")
	public static CommonProxy proxy;

	public static final String MODID = "firma";
	public static final String VERSION = "1.0";
	public static CreativeTabs blockTab, itemTab, gemTab, headTab, toolTab;
	public static RockBlock rock;
	public static RockBlock2 rock2;
	public static BrickBlock rockb;
	public static BrickBlock2 rockb2;
	public static CobbleBlock rockc;
	public static CobbleBlock2 rockc2;
	public static SmoothBlock rocks;
	public static SmoothBlock2 rocks2;
	public static PlankBlock plank;
	public static PlankBlock2 plank2;
	public static DirtBlock dirt;
	public static DirtBlock2 dirt2;
	public static GrassBlock grass;
	public static GrassBlock2 grass2;
	public static GravelBlock gravel;
	public static GravelBlock2 gravel2;
	public static SandBlock sand;
	public static SandBlock2 sand2;
	public static LeafBlock leaf;
	public static LeafBlock2 leaf2;
	public static SaplingBlock sapling;
	public static SaplingBlock2 sapling2;
	public static LogBlock log;
	public static LogBlock2 log2;
	public static ClayBlock clayBlock;
	public static ClayBlock2 clayBlock2;

	public static PebbleItem pebble;
	public static OreItem oreItem;
	public static BrickItem brick;
	public static GemItem gem;
	public static IngotItem ingot;
	public static DoubleIngotItem doubleingot;
	public static MetalSheetItem metalsheet;
	public static ScrapMetalItem scrapmetal;
	public static HideItem hide;

	public static BaseLiquid freshwater;
	public static BaseLiquid saltwater;
	public static BaseLiquid lava;

	public static ArrayList<BaseBlock> allBlocks = new ArrayList<BaseBlock>();
	public static ArrayList<FirmaItem> allItems = new ArrayList<FirmaItem>();
	public static ArrayList<BaseLiquid> allFluids = new ArrayList<BaseLiquid>();
	public static int packetCounter = 0;
	public static final SimpleNetworkWrapper dispatcher = NetworkRegistry.INSTANCE.newSimpleChannel(FirmaMod.MODID);
	public static CraftingManager craftingManager = new CraftingManager();
	public static ClayItem clay;
	public static ArrayList<ToolItem> bunchOfTools = new ArrayList<ToolItem>();
	public static ToolHeads toolHeads;
	public static UnfiredClay unfiredClayBits;
	public static CrucibleBlock crucible;
	public static ShitOnFloor shitOnFloor;
	public static AnvilBlock anvil;

	public static IceBlock ice;
	public static OreBlock ore;
	public static SparseGrassBlock2 grasss2;
	public static SparseGrassBlock grasss;
	


	public FirmaMod() {
		instance = this;
		FluidRegistry.enableUniversalBucket();
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}

}
