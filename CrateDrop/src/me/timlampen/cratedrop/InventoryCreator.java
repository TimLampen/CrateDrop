package me.timlampen.cratedrop;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryCreator {
	public ArrayList<ItemStack> items = new ArrayList<>();
	int i = 0;
	public InventoryCreator(Inventory inv){
		addItems();
		while(i<Main.getPlugin().getConfig().getInt("Iterations")){
			int r2 = new Random().nextInt(27);
			inv.setItem(r2, items.get(r2));
			i++;
		}
		items.clear();
	}
	public void addItems(){
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item1.Name")), Main.getPlugin().getConfig().getInt("Item1.Amount1")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item2.Name")), Main.getPlugin().getConfig().getInt("Item2.Amount2")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item3.Name")), Main.getPlugin().getConfig().getInt("Item3.Amount3")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item4.Name")), Main.getPlugin().getConfig().getInt("Item4.Amount4")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item5.Name")), Main.getPlugin().getConfig().getInt("Item5.Amount5")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item6.Name")), Main.getPlugin().getConfig().getInt("Item6.Amount6")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item7.Name")), Main.getPlugin().getConfig().getInt("Item7.Amount7")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item8.Name")), Main.getPlugin().getConfig().getInt("Item8.Amount8")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item9.Name")), Main.getPlugin().getConfig().getInt("Item9.Amount9")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item10.Name")), Main.getPlugin().getConfig().getInt("Item10.Amount10")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item11.Name")), Main.getPlugin().getConfig().getInt("Item11.Amount11")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item12.Name")), Main.getPlugin().getConfig().getInt("Item12.Amount12")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item13.Name")), Main.getPlugin().getConfig().getInt("Item13.Amount13")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item14.Name")), Main.getPlugin().getConfig().getInt("Item14.Amount14")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item15.Name")), Main.getPlugin().getConfig().getInt("Item15.Amount15")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item16.Name")), Main.getPlugin().getConfig().getInt("Item16.Amount16")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item17.Name")), Main.getPlugin().getConfig().getInt("Item17.Amount17")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item18.Name")), Main.getPlugin().getConfig().getInt("Item18.Amount18")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item19.Name")), Main.getPlugin().getConfig().getInt("Item19.Amount19")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item20.Name")), Main.getPlugin().getConfig().getInt("Item20.Amount20")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item21.Name")), Main.getPlugin().getConfig().getInt("Item21.Amount21")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item22.Name")), Main.getPlugin().getConfig().getInt("Item22.Amount22")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item23.Name")), Main.getPlugin().getConfig().getInt("Item23.Amount23")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item24.Name")), Main.getPlugin().getConfig().getInt("Item24.Amount24")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item25.Name")), Main.getPlugin().getConfig().getInt("Item25.Amount25")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item26.Name")), Main.getPlugin().getConfig().getInt("Item26.Amount26")));
		items.add(new ItemStack(Material.matchMaterial(Main.getPlugin().getConfig().getString("Item27.Name")), Main.getPlugin().getConfig().getInt("Item27.Amount27")));
	}
}
