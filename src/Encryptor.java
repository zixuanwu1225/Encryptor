public class Encryptor
{
    /** A two-dimensional array of single-character strings, instantiated in the constructor */
    private String[][] letterBlock;

    /** The number of rows of letterBlock, set by the constructor */
    private int numRows;

    /** The number of columns of letterBlock, set by the constructor */
    private int numCols;

    /** Constructor*/
    public Encryptor(int r, int c)
    {
        letterBlock = new String[r][c];
        numRows = r;
        numCols = c;
    }

    public String[][] getLetterBlock()
    {
        return letterBlock;
    }

    /** Places a string into letterBlock in row-major order.
     *
     *   @param str  the string to be processed
     *
     *   Postcondition:
     *     if str.length() < numRows * numCols, "A" in each unfilled cell
     *     if str.length() > numRows * numCols, trailing characters are ignored
     */
    public void fillBlock(String str)
    {
        //a = row
        //b=column
        //c=index
        int index = 0;
        int currentRow=0;
        int currentCol=0;
        for(String[] s:letterBlock){
            for (String st:s) {
                if(index >=str.length()){
                    letterBlock[currentRow][currentCol]="A";
                    currentCol+=1;
                    index++;
                }
                else{
                    letterBlock[currentRow][currentCol]=""+ str.charAt(index);
                    currentCol++;
                    index++;
                }
            }
            currentRow++;
            currentCol=0;
        }
    }
    /** Extracts encrypted string from letterBlock in column-major order.
     *
     *   Precondition: letterBlock has been filled
     *
     *   @return the encrypted string from letterBlock
     */

    public String encryptBlock()
    {
        String encrypted = "";
        for(int i=0;i<letterBlock[0].length;i++){
            for(int j=0;j<letterBlock.length;j++){
                encrypted+=letterBlock[j][i];
            }
        }
        return encrypted;
    }


    public String encryptMessage(String message)
    {
        String result = "";
        String temp = message;
        int length = numRows*numCols;
        int now = 0;
        for(int i=0;i<message.length()-1;i++){
            if(now!=length){
                Encryptor e = new Encryptor(numRows,numCols);
                e.fillBlock(temp);
                result+=e.encryptBlock();
            }
            else {
                now=0;
                temp = temp.substring(length);
            }
            now+=length;
        }
        return result;
    }

    /**  Decrypts an encrypted message. All filler 'A's that may have been
     *   added during encryption will be removed, so this assumes that the
     *   original message (BEFORE it was encrypted) did NOT end in a capital A!
     *
     *   NOTE! When you are decrypting an encrypted message,
     *         be sure that you have initialized your Encryptor object
     *         with the same row/column used to encrypted the message! (i.e.
     *         the “encryption key” that is necessary for successful decryption)
     *         This is outlined in the precondition below.
     *
     *   Precondition: the Encryptor object being used for decryption has been
     *                 initialized with the same number of rows and columns
     *                 as was used for the Encryptor object used for encryption.
     *
     *   @param encryptedMessage  the encrypted message to decrypt
     *
     *   @return  the decrypted, original message (which had been encrypted)
     *
     *   TIP: You are encouraged to create other helper methods as you see fit
     *        (e.g. a method to decrypt each section of the decrypted message,
     *         similar to how encryptBlock was used)
     */
    public String decryptMessage(String encryptedMessage)
    {
        return null;
    }
}