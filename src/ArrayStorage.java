import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private int size = 0;
    private Resume[] storage = new Resume[10000];

    void clear() {

        Arrays.fill(storage, null);
        size = 0;
    }

    void save(Resume r) {

        // checking if after adding a new element we will not out of array capacity && checking if the value of r object isn't null
        if(size+1 != storage.length && r != null){ // checking if after adding a new element we will not out of array capacity

            int i = -1;
            //checking if we have in our storage Resume with the uuid as received for saving object if we have such iterating i instance
            for(int j = 0; j < size; j++){
                if(storage[j].uuid.equals(r.uuid)){
                 i++;
                }

            }
            if(i < 0){
                storage[size] = r;
                size++;

            }
            else {
                System.out.println("Resume with uuid " + r.uuid +" is already presented in the base");

            }



        }
        else {
            System.out.println("Resume can't be added as storage is crowded or you passed null Resume");
        }

    }

    Resume get(String uuid) {


        //Moving through array in order to find Resume object with requested value

        Resume resume = null;
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                resume = storage[i];
            }
        }

        if(resume == null){
            System.out.println("Resume isn't exist");
        }

        return resume;
    }

    void delete(String uuid) {

        boolean isDeleted = false;
        //Moving through array in order to find Resume object with requested uuid value
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {

                storage[i] = storage[size-1];

                isDeleted = true;
                storage[size-1] = null;
                size--;


            }
        }

        if(!isDeleted){
            System.out.println("Requested resume wasn't found");
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

       return Arrays.copyOfRange(storage, 0, size);

}

    int size() {

        return size;
    }

    private void update (Resume resume){

        boolean isFound  = false;

        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(resume.uuid)) {

                storage[i] = resume;
                isFound = true;
            }
        }

        if(!isFound){
            System.out.println("Such resume wasn't found");
        }

    }



}
