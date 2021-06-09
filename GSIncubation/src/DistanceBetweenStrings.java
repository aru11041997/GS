
public class DistanceBetweenStrings {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append(
				"In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements");
		sb.append(
				" of a document or visual presentation. Replacing meaningful content that could be distracting with placeholder text");
		sb.append(
				" may allow viewers to focus on graphic aspects such as font, typography, and page layout. It also reduces the need");
		sb.append(
				" for the designer to come up with meaningful text, as they can instead use hastily generated lorem ipsum text. The");
		sb.append(
				" lorem ipsum text is typically a scrambled section of De finibus bonorum et malorum, a 1st-century BC Latin text by");
		sb.append(
				" Cicero, with words altered, added, and removed to make it nonsensical, improper Latin. A variation of the ordinary");
		sb.append(
				" lorem ipsum text has been used in typesetting since the 1960s or earlier, when it was popularized by advertisements");
		sb.append(
				" for Letraset transfer sheets. It was introduced to the Information Age in the mid-1980s by Aldus Corporation, which");
		sb.append(
				" employed it in graphics and word processing templates for its desktop publishing program, PageMaker, for the Apple");
		sb.append(
				" Macintosh. A common form of lorem ipsum reads: Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do");
		sb.append(
				" eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation");
		sb.append(
				" ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit");
		sb.append(
				" esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui");
		sb.append(" officia deserunt mollit anim id est laborum.");
		
		sb.append("This is a sample document we just made up");

		String document = sb.toString();
		System.out.println(shortestDistance(document, "we", "just"));
		System.out.println(shortestDistance(document, "and", "graphic"));
		System.out.println(shortestDistance(document, "transfer", "it"));
		System.out.println(shortestDistance(document, "layout", "It"));
		System.out.println(shortestDistance(document, "Design", "filler"));
		System.out.println(shortestDistance(document, "It", "transfer"));
		System.out.println(shortestDistance(document, "of", "lorem"));
		System.out.println(shortestDistance(document, "thiswordisnotthere", "lorem"));
	}

	public static double shortestDistance(String document, String word1, String word2) {
		if (document == null || word1 == null || word2 == null)
			return -1;
		if (word1.equals(word2))
			return 0;
		String[] documentWords = document.split("[. ,]");
		int index = 0;
		int distanceToWord1 = 0;
		int distanceToWord2 = 0;
		double word1Midvalue = 0;
		double word2Midvalue = 0;
		double minResultValue = Integer.MAX_VALUE;
		for (String word : documentWords) {
			if (word.equalsIgnoreCase(word1)) {
				distanceToWord1 = index;
				word1Midvalue = word1.length() / 2.0;
				distanceToWord1 += word1Midvalue;
			}
			if (word.equalsIgnoreCase(word2)) {
				distanceToWord2 = index;
				word2Midvalue = word2.length() / 2.0;
				distanceToWord2 += word2Midvalue;
			}
			index += word.length() + 1;
			double resultValue=0;
			 if (distanceToWord1 > 0 && distanceToWord2 > 0) {
				 resultValue = Math.abs(distanceToWord1 - distanceToWord2);
	                if (resultValue < minResultValue) {
	                    minResultValue = resultValue;
	                }
	            }
		}
		if (minResultValue == Integer.MAX_VALUE) {
			return -1;
		}
		return minResultValue;
	}

}
