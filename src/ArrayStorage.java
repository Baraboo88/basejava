import java.util.ArrayList;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private int size = 0;
    Resume[] storage = new Resume[10000];

    void clear() {

        // moving though array in order to find non-null elements
        for (int i = 0; i < size; i++) {
                storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {


        if(size+1 != storage.length){ // checking if after adding a new element we will not out of array capacity
            storage[size] = r;
            size++;
        }

    }

    Resume get(String uuid) {


        //Moving through array in order to find Resume object with requested value
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return storage[i];
            }
        }

        return null;
    }

    void delete(String uuid) {

        //Moving through array in order to find Resume object with requested uuid value
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {

                for (int j = i; j < size - 1; j++) {

                    storage[j] = storage[j + 1];

                }
                storage[size-1] = null;
                size--;

            }
        }


    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        Resume [] outcomeArray = new Resume[size];

        //storing non-null elements into outcomeArray
        for (int i = 0; i < size; i++) {
        outcomeArray[i] = storage[i];
        }

        return outcomeArray;
}

    int size() {

        return size;
    }
}
