import java.util.ArrayList;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        // moving though array in order to find non-equal elements
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) { //if element is not equal to null - assign to this element "null"
                storage[i] = null;
            }
        }
    }

    void save(Resume r) {

        //moving through array in order to find first null element
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) { //assigning argument value to the first null element of the array
                storage[i] = r;
                break;
            }
        }

    }

    Resume get(String uuid) {

        Resume returningObject = new Resume(); //creating "Dummy" Resume element in order not to have NullPointerException

        returningObject.uuid = "Dummy input"; //assigning value in order to have sensible output when we are receiving "Dummy" input

        //Moving through array in order to find Resume object with requested value
        for (Resume resume : storage) {
            if (resume != null&& uuid.equals(resume.uuid)) { //using null check in order not to have Exception and equality of the array element object with method argument value

                returningObject = resume; //assigning object reference to the returning object
            }
        }

        return returningObject;
    }

    void delete(String uuid) {

        //Moving through array in order to find Resume object with requested uuid value
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && storage[i].uuid.equals(uuid)) { //using null check in order not to have Exception and equality of the array element object with method argument value
                storage[i] = null;
                for (int j = i; j < storage.length - 1; j++) { //moving all elements of the array 1 index to the left. Using storage.length - 1 in order not to have NullPointerException when "j" will be equal to the last index of the array

                    storage[j] = storage[j + 1];

                }

            }
        }

        storage[storage.length - 1] = null; // adding null in order to complete array element moving if we have fully populated array
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        List<Resume> listOfResumes = new ArrayList<>(); //creating supportive Arraylist

        //adding all non-null elements of the array into the supportive arraylist
        for (Resume resume : storage) {
            if (resume != null) {
                listOfResumes.add(resume);
            }
        }

        return listOfResumes.toArray(new Resume[0]); //converting Arraylist into Array and returning it
    }

    int size() {
        int count = 0; // creating count number

        //moving through the array in order to find all non-null elements and iterate the value of cont instance
        for (Resume resume : storage) {
            if (resume != null) {
                count++;
            }
        }
        return count; //returning count value
    }
}
