package geometries;

import BVH.AABB;
import BVH.BoundingBoxTree;
import primitives.Ray;

import java.util.LinkedList;
import java.util.List;

/**
 * Geometries' class.
 * Represents a collection of geometries.
 */
public class Geometries extends Intersectable {
    private final BoundingBoxTree boundingBoxTree = new BoundingBoxTree();
    ;
    private final List<Intersectable> geometriesInScene = new LinkedList<>();

    /**
     * A default constructor that create new empty arrayList intersectable-geometries
     */
    public Geometries() {
    }

    /**
     * Constructor that receives list of geometries and puts them in a new arrayList.
     *
     * @param geometries The geometries to add to the list.
     */
    public Geometries(Intersectable... geometries) {
        boundingBoxTree.buildHierarchy(List.of(geometries));
    }

    public AABB calculateAABB() {
        return boundingBoxTree.calculateAABB();
    }

    /**
     * Adds the given geometries to the list of geometries in the scene.
     *
     * @param geometries The geometries to add to the list.
     */
    public void add(Intersectable... geometries) {
        boundingBoxTree.buildHierarchy(List.of(geometries));

    }

    /**
     * Finds the intersection points between the given ray and the geometries in the scene.
     *
     * @param ray the ray to intersect with the geometries
     * @return a list of intersection points between the ray and the geometries,
     */
    @Override
    protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray, double maxDistance) {
        List<GeoPoint> result = boundingBoxTree.findGeoIntersections(ray, maxDistance);

        if (result.isEmpty()) {
            return null;
        }
        return result;
    }

}
