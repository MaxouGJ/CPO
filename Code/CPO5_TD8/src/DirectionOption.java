enum Direction {
    Nord, Sud, Est, Ouest;
}

public class DirectionOption extends Option {

    Direction direction = Direction.Nord;

    public DirectionOption(String nom) {
        super(nom.split("=", 2)[0]);
        String[] args = nom.split("=", 2);
        if(args.length == 2){
            direction = Direction.valueOf(args[1]);
        }
    }

    @Override
    public String toConfigurationLine() {
        String motif = "%s#%s=%s";
        return (String.format(motif,getClass().getName(), nom, direction.name())); 
    }

}
