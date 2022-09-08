import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageReceiver extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent e){

        if(!e.isFromGuild()){
            return;
        }

        System.out.println("Nachricht erhalten: " + e.getMessage().getContentStripped());

        if(e.getMessage().getContentRaw().equals("clear")){

            for(Company c : Company.values()){
                Role companyRole = e.getGuild().getRoleById(c.getRoleID());
                if(companyRole != null){

                }
            }

        }

    }



}
