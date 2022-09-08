import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ReactListener extends ListenerAdapter {
    private String[] messageIDs;
    private Guild server;
    ReactListener(String[] messageIDs, Guild server){
        super();
        this.messageIDs = messageIDs;
        this.server  = server;
    }
    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
        super.onMessageReactionAdd(event);

        for (int i = 0; i < messageIDs.length; i++){
            if (messageIDs[i].equals("" + event.getMessageId())){
                try {
                    int id = 10 * i + (event.getEmoji().toString().charAt(16)) - 48;
                    server.addRoleToMember(event.getMember(), server.getRoleById(Company.values()[id].getRoleID())).queueAfter(50, TimeUnit.MILLISECONDS);
                } catch (Exception e){
                    break;
                }
            }
        }
        System.out.println("Reagiert auf " + event.getEmoji());
    }
}
