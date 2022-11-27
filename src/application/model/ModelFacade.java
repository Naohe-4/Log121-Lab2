package application.model;

import java.util.LinkedList;

public class ModelFacade {


    ImageModel imageModel;
    LinkedList<Perspective> perspectives = new LinkedList<Perspective>();


    /**
     *
     * @param index
     * @return the perspective at the index if it exists
     */
    public Perspective getPerspective(int index) {
        if (index < perspectives.size() && index >= 0) {
            return perspectives.get(index);
        }
        return null;
    }

    /**
     * if perspective at index exist, return that
     * if perspective at index does not exist, return a new perspective
     * if the index is equal to the number of perspectives, add the new perspective to the others
     * @param index
     * @return
     */
    public Perspective getPerspectiveFailsafe(int index) {
        Perspective p = getPerspective(index);
        if (p == null) {
            p = new Perspective();
        }
        if (index == perspectives.size()) {
            perspectives.add(p);
        }

        return p;
    }

    /**
     * wrap the model into a class for ease of access
     * @param index
     * @return
     */
    public RenderData getRenderData(int index) {
        return new RenderData(imageModel.getData(), getPerspectiveFailsafe(index));
    }


}