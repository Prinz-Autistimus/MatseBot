import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageReceiver extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent e){

        if(!e.isFromGuild()){
            return;
        }

        System.out.println("Nachricht erhalten: " + e.getMessage().getContentStripped());

        if(e.getMessage().getContentRaw().equals("Hallo Bot!")){
            e.getChannel().sendMessage("Hallo " + e.getAuthor().getName() + "!").queue();
        }

        if(e.getMessage().getContentRaw().equals("Rolle bitte")){
            e.getGuild().addRoleToMember(e.getMember(), e.getGuild().getRoleById("1017137254034055179")).queue();
        }

    }



}
