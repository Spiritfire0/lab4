package WhatIsACar;

import java.util.Stack;

public class Ramp<T> {
    private boolean isRampUp = true;
    private Stack<T> content = new Stack<>();

    public boolean getRamp() {
        return isRampUp;
    }

    public Stack<T> getContent() {
        return content;
    }

    public void raiseRamp () {
        isRampUp = true;
    }
    public void lowerRamp () {
        isRampUp = false;
    }
    public void loadTrailer(T item) {
        if(isRampUp) return;
        content.push(item);
    }

    public void offloadItem() {
        if(isRampUp) return;
        content.pop();
    }
}
