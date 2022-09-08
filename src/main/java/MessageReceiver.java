import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class MessageReceiver extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent e){

        if(!e.isFromGuild()){
            return;
        }

        String message = e.getMessage().getContentRaw();
        System.out.println("Nachricht erhalten: " + message);

        if(e.getMessage().getContentRaw().equals("!clear")){



        }

        switch (message){

            case "!clear" -> {
                for(Company c : Company.values()){
                    Role companyRole = e.getGuild().getRoleById(c.getRoleID());
                    if(companyRole != null){
                        companyRole.delete().queue();
                    }
                }
            }

            case "!generate" -> {
                MainClass.generateRoles(e.getGuild());
            }

        }



    }



}
