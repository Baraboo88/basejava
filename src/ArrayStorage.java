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
                storage[i] = null; // assigning null to those elements
        }
        size = 0; // reset size value
    }

    void save(Resume r) {


        if(size+1 != storage.length){ // checking if after adding a new element we will not out of array capacity
            storage[size] = r;
            size++;
        }

    }

    Resume get(String uuid) {

        Resume returningObject = null; //creating Resume reference variable with null value

        //Moving through array in order to find Resume object with requested value
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {// checking if requested value is equals to the array element field value
                returningObject = storage[i]; //assigning object reference from storage array to the returning reference
            }
        }

        return returningObject;
    }

    void delete(String uuid) {

        //Moving through array in order to find Resume object with requested uuid value
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) { //using equality check in order to find an element in the array which equal to method argument value

                for (int j = i; j < storage.length - 1; j++) { //moving all elements of the array 1 index to the left. Using storage.length - 1 in order not to have NullPointerException when "j" will be equal to the last index of the array

                    storage[j] = storage[j + 1];

                }
                size--; // decrementing size value

            }
        }

        storage[storage.length - 1] = null; // adding null in order to complete array element shifting if we have fully populated array
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

        return size; //returning value of size instance fgd
    }
}
