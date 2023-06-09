package com.knock.bmt.admin.enums

import org.passay.CharacterData

enum class PasswordCharacterData(val code: String, val charString: String) : CharacterData {

    /** Lower case characters. */
    LowerCase("INSUFFICIENT_LOWERCASE", "abcdefghijklmnopqrstuvwxyz"),

    /** Upper case characters. */
    UpperCase("INSUFFICIENT_UPPERCASE", "ABCDEFGHIJKLMNOPQRSTUVWXYZ"),

    /** Digit characters. */
    Digit("INSUFFICIENT_DIGIT", "0123456789"),

    /** Alphabetical characters (upper and lower case). */
    Alphabetical("INSUFFICIENT_ALPHABETICAL", UpperCase.getCharacters() + LowerCase.getCharacters()),

    /** Special characters. */
    Special(
        "INSUFFICIENT_SPECIAL",
        // ASCII symbols
        "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~");

    /** Error code.  */
    private val errorCode: String = code

    /** Characters.  */
    private val characters: String = charString

    override fun getErrorCode(): String? {
        return errorCode
    }

    override fun getCharacters(): String? {
        return characters
    }
}