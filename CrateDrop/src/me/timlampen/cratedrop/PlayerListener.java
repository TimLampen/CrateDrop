package me.timlampen.cratedrop;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

import net.minecraft.server.v1_7_R3.TileEntityChest;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;

public class PlayerListener implements Listener{
	
	ArrayList<Location> loc = new ArrayList<Location>();
	int ran1xconfig = Main.getPlugin().getConfig().getInt("Crate.Coords1.X");
	int ran1zconfig = Main.getPlugin().getConfig().getInt("Crate.Coords1.Z");
	int ran2xconfig = Main.getPlugin().getConfig().getInt("Crate.Coords2.X");
	int ran2zconfig = Main.getPlugin().getConfig().getInt("Crate.Coords2.Z");
	int ranx;
	int ranz;
	int x;
	int z;
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		String prefix = ChatColor.BLACK+"["+ChatColor.RED+"Quick"+ChatColor.GOLD+"Raid"+ChatColor.BLACK+"] " + ChatColor.RESET;
		Player player = event.getPlayer();
		if(Bukkit.getOnlinePlayers().length<=1){
			if(ran1xconfig < ran2xconfig && ran1zconfig < ran2zconfig){
				this.ranx = ran1xconfig - ran2xconfig;
				this.ranz = ran1zconfig - ran2zconfig;
				this.x = new Random().nextInt(ranx)+1;
				this.z = new Random().nextInt(ranz)+1;
				FallingBlock fb = player.getWorld().spawnFallingBlock(new Location(player.getWorld(), ran2xconfig+x, 200, ran2zconfig+z), Material.CHEST, (byte)0);
				loc.clear();
				loc.add(fb.getLocation());
				player.sendMessage("1");
			}
			else if(ran1xconfig > ran2xconfig && ran1zconfig > ran2zconfig){
				this.ranx = ran2xconfig - ran1xconfig;
				this.ranz = ran2zconfig - ran1zconfig;
				this.x = new Random().nextInt(ranx)+1;
				this.z = new Random().nextInt(ranz)+1;
				FallingBlock fb = player.getWorld().spawnFallingBlock(new Location(player.getWorld(), ran2xconfig+x, 200, ran2zconfig+z), Material.CHEST, (byte)0);
				loc.clear();
				loc.add(fb.getLocation());
				player.sendMessage("2");
			}
			else if(ran1xconfig < ran2xconfig && ran1zconfig > ran2zconfig){
				this.ranx = ran2xconfig - ran1xconfig;
				this.ranz = ran1zconfig - ran2zconfig;
				this.x = new Random().nextInt(ranx)+1;
				this.z = new Random().nextInt(ranz)+1;
				FallingBlock fb = player.getWorld().spawnFallingBlock(new Location(player.getWorld(), ran2xconfig+x, 200, ran2zconfig+z), Material.CHEST, (byte)0);
				loc.clear();
				loc.add(fb.getLocation());
				player.sendMessage("3");
			}
			else if(ran1xconfig > ran2xconfig && ran1zconfig < ran2zconfig){
				this.ranx = ran1xconfig - ran2xconfig;
				this.ranz = ran2zconfig - ran1zconfig;
				this.x =  new Random().nextInt(ranx)+1;
				this.z = new Random().nextInt(ranz)+1;
				FallingBlock fb = player.getWorld().spawnFallingBlock(new Location(player.getWorld(), ran2xconfig+x, 200, ran2zconfig+z), Material.CHEST, (byte)0);
				loc.clear();
				loc.add(fb.getLocation());
				player.sendMessage("4");
			}
			else{
				FallingBlock fb = player.getWorld().spawnFallingBlock(new Location(player.getWorld(), ran2xconfig+x, 200, ran2zconfig+z), Material.CHEST, (byte)0);
				loc.clear();
				loc.add(fb.getLocation());
				player.sendMessage("e");
			}
			player.getTargetBlock(null, 10).setType(Material.AIR);
			Bukkit.broadcastMessage(prefix + player.getName() + " has found a dropbox at X:" + player.getLocation().getX() + " Z:" + player.getLocation().getZ() + ". Another has dropped at X: " + (ran2xconfig+x) + " Z: " + (ran2xconfig+z) + ".");
		}
	}
	@SuppressWarnings("unused")
	@EventHandler
	public void onBlockChange(EntityChangeBlockEvent event){
		if(event.getEntity() instanceof FallingBlock) {
			Bukkit.broadcastMessage("1");
			 FallingBlock fblock = (FallingBlock) event.getEntity();
			 event.getBlock().setType(Material.CHEST);
			 if(event.getBlock().getType() == Material.CHEST) {
					Bukkit.broadcastMessage("2");
				 Chest chest = (Chest) event.getBlock().getState();
				InventoryCreator ic = new InventoryCreator(chest.getInventory());
			 }
		}
	}
	
	@SuppressWarnings({ "unused", "deprecation" })
	@EventHandler
	public void onChestOpen(InventoryOpenEvent event){
		String prefix = ChatColor.BLACK+"["+ChatColor.RED+"Quick"+ChatColor.GOLD+"Raid"+ChatColor.BLACK+"] " + ChatColor.RESET;
		Player player = (Player) event.getPlayer();
		if(event.getInventory().getType()==InventoryType.CHEST && event.getInventory().getHolder() instanceof Chest){
			Chest chestz = (Chest) event.getInventory().getHolder();
			if(loc.get(0).equals(new Location(player.getWorld(), chestz.getLocation().getX(), 0, chestz.getLocation().getZ()))){
				Inventory inv = event.getInventory();
				if(player.getTargetBlock(null, 10).getType() == Material.CHEST){
					if(ran1xconfig < ran2xconfig && ran1zconfig < ran2zconfig){
						this.ranx = ran1xconfig - ran2xconfig;
						this.ranz = ran1zconfig - ran2zconfig;
						this.x = new Random().nextInt(ranx)+1;
						this.z = new Random().nextInt(ranz)+1;
						FallingBlock fb = player.getWorld().spawnFallingBlock(new Location(player.getWorld(), ran2xconfig+x, 200, ran2zconfig+z), Material.CHEST, (byte)0);
						loc.clear();
						loc.add(fb.getLocation());
					}
					else if(ran1xconfig > ran2xconfig && ran1zconfig > ran2zconfig){
						this.ranx = ran2xconfig - ran1xconfig;
						this.ranz = ran2zconfig - ran1zconfig;
						this.x = new Random().nextInt(ranx)+1;
						this.z = new Random().nextInt(ranz)+1;
						FallingBlock fb = player.getWorld().spawnFallingBlock(new Location(player.getWorld(), ran2xconfig+x, 200, ran2zconfig+z), Material.CHEST, (byte)0);
						loc.clear();
						loc.add(fb.getLocation());
					}
					else if(ran1xconfig < ran2xconfig && ran1zconfig > ran2zconfig){
						this.ranx = ran2xconfig - ran1xconfig;
						this.ranz = ran1zconfig - ran2zconfig;
						this.x = new Random().nextInt(ranx)+1;
						this.z = new Random().nextInt(ranz)+1;
						FallingBlock fb = player.getWorld().spawnFallingBlock(new Location(player.getWorld(), ran2xconfig+x, 200, ran2zconfig+z), Material.CHEST, (byte)0);
						loc.clear();
						loc.add(fb.getLocation());
					}
					else if(ran1xconfig > ran2xconfig && ran1zconfig < ran2zconfig){
						this.ranx = ran1xconfig - ran2xconfig;
						this.ranz = ran2zconfig - ran1zconfig;
						this.x =  new Random().nextInt(ranx)+1;
						this.z = new Random().nextInt(ranz)+1;
						FallingBlock fb = player.getWorld().spawnFallingBlock(new Location(player.getWorld(), ran2xconfig+x, 200, ran2zconfig+z), Material.CHEST, (byte)0);
						loc.clear();
						loc.add(fb.getLocation());
					}
					else{
						FallingBlock fb = player.getWorld().spawnFallingBlock(new Location(player.getWorld(), ran2xconfig+x, 200, ran2zconfig+z), Material.CHEST, (byte)0);
						loc.clear();
						loc.add(fb.getLocation());
						
					}
					player.getTargetBlock(null, 10).setType(Material.AIR);
					Bukkit.broadcastMessage(prefix + player.getName() + " has found a dropbox at X:" + player.getLocation().getX() + " Z:" + player.getLocation().getZ() + ". Another has dropped at X: " + x + " Z: " + z + ".");
				}
			}
	}
	}

}
