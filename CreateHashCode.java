
/**
* Create a hash code for the given member and return it.
*/
public String createHashCode(Profile member) {
	String hashCode = "";

	hashCode = getProfileHash(member.getRandomId(), member.getCreatedTimestamp(), "Registration");

	return hashCode;
}

/**	
 * Generate a SHA256 hash code for the given details and return it.
 * @param randomId The randomId of the member.
 * @param createdTimestamp The timestamp that the member profile was created.
 * @param action A textual representation of the current action.
*/
public static String getProfileHash(String randomId, Timestamp createdTimestamp, String action) {
	return generateHash(Arrays.asList(randomId, createdTimestamp.toString(), action));
}

/**
 * Generates the hash from the list of attributes.
 * 
 * This is a generic generation where the number of attributes of the hash are dynamic.
 * 
 * @param attributes
 * @return The calculated hash
 */
public static String generateHash(List<String> attributes) {
	if(attributes == null || attributes.isEmpty()) {
	 	throw new IllegalArgumentException("Hashing attributes may not be empty");
	}
	return hashSHA256("Secret" + StringUtils.join(attributes.toArray()));
}


public static String hashSHA256(String value){
    	MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(value.getBytes());
			return hexString(md.digest());
		} catch (NoSuchAlgorithmException exception) {			
			LOG.error("Can not find HashSHA256, message : " + exception.getMessage());
		}
	return null;
}

