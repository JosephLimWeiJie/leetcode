class Solution {
    public static String defangIPaddr(String address) {
        address = address.replace(".", "[.]");
        return address;
    }
}
