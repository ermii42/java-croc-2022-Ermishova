package ru.croc.task6;

class AnnotatedImage {

    private final String imagePath;

    private final Annotation[] annotations;

    public AnnotatedImage(String imagePath, Annotation... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public Annotation[] getAnnotations() {
        return this.annotations;
    }

    public Annotation findByPoint(int x, int y) {
        for(Annotation an: annotations){
                if (an.inArea(x, y)) return an;
        }
        return null;
    }

    public Annotation findByLabel(String label) {
        for(Annotation an: annotations){
            if(an.getSignature().contains(label)) return an;
        }
        return null;
    }


}
