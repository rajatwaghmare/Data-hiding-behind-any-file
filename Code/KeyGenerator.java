import java.math.BigInteger;

public class KeyGenerator {
    private BigInteger p;
    private BigInteger q;
    private BigInteger n;
    private BigInteger phi;
    private BigInteger d;
    private BigInteger e;

  
    public KeyGenerator() {
    }

    /**
     * It calculates n and phi(n)
     *
     * @return boolean
     */
    boolean determineN() {
        try {
            n = new BigInteger(String.valueOf(
                    p.intValue() * q.intValue()));
            phi = new BigInteger(String.valueOf(
                    (p.intValue() - 1) * (q.intValue() - 1)));
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    BigInteger getN() {
        return n;
    }

    /**
     * calculates available private keys and returns all available private key
     * values as string
     *
     * @return String
     */
    String getDValues() {
        String dValues = new String("");

        BigInteger i = new BigInteger("1");
        BigInteger j = new BigInteger("1");
        int count = 1;          // to determine no of d values

        while (i.intValue() <= (10 * n.intValue())) {
            if (((e.multiply(i)).mod(phi)).intValue() == 1) {
                dValues += i.intValue() + "\t";
                if (count % 5 == 0) {
                    dValues += "\n";
                }
                count++;
            }
            i = i.add(j);   // increment i value by 1
        }

        return dValues;
    }

    /**
     * calculated available public keys and returns all available private key
     * values as string
     *
     * @return String
     */
    String getEValues() {
        String eValues = new String("");

        BigInteger i = new BigInteger("17");
        BigInteger j = new BigInteger("1");
        int count = 1;          // to determine no of e values

        determineN();

        while (i.intValue() < phi.intValue()) {
            if (phi.gcd(i).intValue() == 1) {
                eValues += i.intValue() + "\t";
                if (count % 5 == 0) {
                    eValues += "\n";
                }
                count++;
            }
            i = i.add(j);   // increment i value by 1
        }

        return eValues;
    }

    /**
     * it sets p if it is prime and is a number
     *
     * @param pVal
     * @return boolean
     */
    boolean setP(String pVal) {
        int pTest;
        try {
            pTest = Integer.parseInt(pVal);
        } catch (NumberFormatException ex) {
            return false;
        }
        if (isPrime(pTest)) {
            p = new BigInteger(pVal);
            return true;
        }
        return false;
    }

    /**
     * it sets q if it is prime and is a number
     *
     * @param qVal
     * @return boolean
     */
    boolean setQ(String qVal) {
        int qTest;
        try {
            qTest = Integer.parseInt(qVal);
        } catch (NumberFormatException ex) {
            return false;
        }
        if (isPrime(qTest)) {
            q = new BigInteger(qVal);
            return true;
        }
        return false;
    }

    /**
     * it sets e value if satify the constraints of public key
     *
     * @param eVal
     * @return boolean
     */
    boolean setE(String eVal) {
        int eTest;
        try {
            eTest = Integer.parseInt(eVal);
        } catch (NumberFormatException ex) {
            return false;
        }
        if (phi.gcd(new BigInteger(eVal)).intValue() == 1) {
            e = new BigInteger(eVal);
            return true;
        }
        return false;
    }

    BigInteger getE() {
        return e;
    }

    /**
     * it sets d value if satisfy the constraints of private key
     *
     * @param dVal
     * @return boolean
     */
    boolean setD(String dVal) {
        int dTest;
        try {
            dTest = Integer.parseInt(dVal);
        } catch (NumberFormatException ex) {
            return false;
        }
        if (((e.multiply(new BigInteger(dVal))).mod(phi)).intValue() == 1) {
            d = new BigInteger(dVal);
            return true;
        }
        return false;
    }

    BigInteger getD() {
        return d;
    }

    
    /**
     * Tests weather given number is prime or not
     *
     * @param val
     * @return boolean
     */
    private boolean isPrime(int val) {
        for (int i = 2; i < val / 2; i++) {
            if (val % i == 0)
                return false;
        }
        return true;
    }
}