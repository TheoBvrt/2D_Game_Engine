package ch.bouverat.engine.game_engine.component;

import ch.bouverat.engine.game_engine.core.BehaviourManager;
import ch.bouverat.engine.game_engine.core.Error;
import ch.bouverat.engine.game_engine.core.GameBehaviour;
import ch.bouverat.engine.game_engine.core.enums.ErrorType;
import ch.bouverat.engine.game_engine.utils.Vector2;

public class Collider extends Component{

    private final double colliderSizeY = parent.getSizeY();
    private final double colliderSizeX = parent.getSizeX();
    public Vector2 colliderOrigin = parent.getComponent(Transform.class).position;
    public Vector2 colliderEnd = new Vector2(colliderOrigin.x + colliderSizeX, colliderOrigin.y + colliderSizeY);

    public double[] top = new double[4];
    public double[] right = new double[4];
    public double[] bottom = new double[4];
    public double[] left = new double[4];


    public Collider(GameBehaviour parent) {
        super(parent);
        require(Transform.class);
        Transform transform = parent.getComponent(Transform.class);
        top[0] = transform.position.y;
        top[1] = transform.position.x;
        top[2] = transform.position.y;
        top[3] = transform.position.x + parent.getSizeX();



        if (parent.getSizeX() == 0 || parent.getSizeY() == 0) {
            Error.message(ErrorType.WARNING, parent.getClass().getSimpleName() + ".java", "size values are not initialized");
        }
    }
}
