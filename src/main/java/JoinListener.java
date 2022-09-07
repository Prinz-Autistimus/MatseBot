import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class JoinListener extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent e) {
        super.onGuildMemberJoin(e);
        System.out.println("User joined");
        e.getGuild().addRoleToMember(e.getMember(), e.getGuild().getRoleById("1017137254034055179")).queue();
    }
}
