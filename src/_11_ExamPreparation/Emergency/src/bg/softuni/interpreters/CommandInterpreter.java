package bg.softuni.interpreters;

import bg.softuni.annotations.InjectArgs;
import bg.softuni.annotations.InjectType;
import bg.softuni.commands.Executable;
import bg.softuni.core.ManagementSystem;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreter implements Interpreter {
    private static final String COMMAND_PACKAGE = "bg.softuni.commands.";
    private static final String COMMAND_SUFFIX = "Command";
    private ManagementSystem managementSystem;

    public CommandInterpreter(ManagementSystem managementSystem) {
        this.managementSystem = managementSystem;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Executable interpretCommand(String line) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Executable executable = null;
        String[] params = line.split("[\\|]+");
        String commandName = params[0];
        Class<Executable> commandClass = (Class<Executable>) Class.forName(COMMAND_PACKAGE + commandName + COMMAND_SUFFIX);
        Constructor<Executable> constructor = commandClass.getDeclaredConstructor(ManagementSystem.class);
        executable = constructor.newInstance(this.managementSystem);
        this.injectDependencies(executable, params);
        return executable;
    }

    private void injectDependencies(Executable executable, String[] params) throws IllegalAccessException {
        Field[] fields = executable.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectArgs.class)) {
                field.setAccessible(true);
                field.set(executable,params);
                return;
            } else if (field.isAnnotationPresent(InjectType.class)) {
                field.setAccessible(true);
                field.set(executable,params[1]);
                return;
            }
        }
    }
}
