import net.dv8tion.jda.api.events.role.RoleCreateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class RoleAddListener extends ListenerAdapter {

    @Override
    public void onRoleCreate(@NotNull RoleCreateEvent e) {
        super.onRoleCreate(e);

        Company c = Company.getByName(e.getRole().getName());

        if(c != null){
            c.setRoleID(e.getRole().getId());
        }


    }
}
