package de.presti.opensource.teamchat.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.presti.opensource.teamchat.main.Data;

public class TeamChat implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	if(sender instanceof Player) {
		Player p = (Player)sender;
		if(p.hasPermission("tc.chat") || p.hasPermission("tc.*")) {
		   if(args.length == 0) {
			p.sendMessage(Data.prefix + "Pls use §c/tc [message]");
		   } else {
	            StringBuilder sb = new StringBuilder();
	            int i = 0;
	            while (i < args.length) {
	                sb.append(String.valueOf(args[i]) + " ");
	                ++i;
	            }
	            String st = sb.toString();
	            for(Player all : Bukkit.getOnlinePlayers()) {
	            	if(all.hasPermission("tc.chat") || all.hasPermission("tc.*")) {
	            		all.sendMessage(Data.prefix + "§c" + p.getName() + "§7: §2" + st.replace("&", "§"));
	            		System.out.println("TeamChat -> " + p.getName() + ": " + st);
	            	}
	            }
		   }
	    } else
	    	p.sendMessage(Data.noperms);
	   } else {
		   if(sender.hasPermission("tc.chat") || sender.hasPermission("tc.*")) {
			  if(args.length == 0) {
				System.out.println("TeamChat -> Pls use §c/tc [message]");
			  } else {
           StringBuilder sb = new StringBuilder();
           int i = 0;
           while (i < args.length) {
               sb.append(String.valueOf(args[i]) + " ");
               ++i;
           }
           String st = sb.toString();
           for(Player all : Bukkit.getOnlinePlayers()) {
           	if(all.hasPermission("tc.chat") || all.hasPermission("tc.*")) {
           		all.sendMessage(Data.prefix + "§cConsole§7: §2" + st.replace("&", "§"));
        		System.out.println("TeamChat -> " + "Console: " + st);
           	 }
            }
           }  
		 } else
			 sender.sendMessage(Data.noperms);
	   }
		return false;
	}

}
