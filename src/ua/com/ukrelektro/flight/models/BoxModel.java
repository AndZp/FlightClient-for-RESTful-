package ua.com.ukrelektro.flight.models;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class BoxModel<T> extends AbstractListModel<T> implements ComboBoxModel<T> {

    private List<T> list;
    private T selectedItem;

    public BoxModel(List<T> list) {
        this.list = list;
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public T getElementAt(int i) {
        return list.get(i);
    }

    @Override
    public void setSelectedItem(Object o) {
        selectedItem = (T) o;
    }

    @Override
    public T getSelectedItem() {
        return selectedItem;
    }

}
