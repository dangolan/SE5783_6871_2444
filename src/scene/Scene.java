package scene;

import geometries.Geometries;
import geometries.Intersectable;
import lighting.AmbientLight;
import primitives.Color;

public class Scene {
    public String name;
    public Color background;
    public AmbientLight ambientLight;
    public Geometries geometries;
    /**
     * construct a scene. giving default values to all the fields
     */
    public Scene(String name) {
        this.geometries = new Geometries();
        this.name = name;
        this.background = Color.BLACK;
        this.ambientLight = AmbientLight.NONE;
    }

    public Scene setBackground(Color background) {
        this.background = background;
        return this;
    }

    public Scene setGeometries(Geometries geometries) {
        this.geometries = geometries;
        return this;
    }

    public Scene addGeometry(Intersectable geometry){
        geometries.add(geometry);
        return this;
    }

    public Scene setAmbientLight(AmbientLight ambientLight) {
        this.ambientLight = ambientLight;
        return this;
    }
}