/**
 * HW3 - Automated Test Application
 * 
 * This application contains five standalone tests for password evaluation,
 * utilities, policy enforcement, and history tracking.
 * Each test runs as a simple mainline without JUnit.
 * 
 * Author: Anshika Rai
 * Date: 26th March 2025
 */

 public class HW3 {

    /**
     * Entry point to run all five automated tests.
     */
    public static void main(String[] args) {
        testPasswordStrengthEvaluator();
        testMissingSpecialCharacter();
        testMultiplePolicyViolations();
        testPasswordReuseDetection();
        testShortPasswordLength();
    }

    /**
     * Test: PasswordStrengthEvaluator.evaluate() should return "Strong"
     * for a complex password with all required characteristics.
     */
    public static void testPasswordStrengthEvaluator() {
        String password = "Str0ngP@ssw0rd!";
        String result = PasswordStrengthEvaluator.evaluate(password);
        System.out.println("Test 1 - Strong Password Evaluation:");
        System.out.println("Expected: Strong");
        System.out.println("Actual:   " + result);
        System.out.println(result.equals("Strong") ? "PASS\n" : "FAIL\n");
    }

    /**
     * Test: PasswordUtils.containsSpecialCharacter() should return false
     * for a password that lacks special characters.
     */
    public static void testMissingSpecialCharacter() {
        String password = "Password123";
        boolean hasSpecial = PasswordUtils.containsSpecialCharacter(password);
        System.out.println("Test 2 - Missing Special Character:");
        System.out.println("Expected: false");
        System.out.println("Actual:   " + hasSpecial);
        System.out.println(!hasSpecial ? "PASS\n" : "FAIL\n");
    }

    /**
     * Test: PasswordPolicyEnforcer.enforce() should return multiple violations
     * for a very weak password that breaks several rules.
     */
    public static void testMultiplePolicyViolations() {
        String password = "1234";
        var violations = PasswordPolicyEnforcer.enforce(password);
        System.out.println("Test 3 - Multiple Policy Violations:");
        System.out.println("Expected: 2+ violations");
        System.out.println("Actual:   " + violations);
        System.out.println((violations != null && violations.size() >= 2) ? "PASS\n" : "FAIL\n");
    }

    /**
     * Test: PasswordHistoryManager should detect when a password is reused.
     */
    public static void testPasswordReuseDetection() {
        PasswordHistoryManager history = new PasswordHistoryManager();
        String password = "Repeat@123";
        history.addPassword(password);
        boolean reused = history.isReused(password);
        System.out.println("Test 4 - Password Reuse Detection:");
        System.out.println("Expected: true");
        System.out.println("Actual:   " + reused);
        System.out.println(reused ? "PASS\n" : "FAIL\n");
    }

    /**
     * Test: PasswordUtils.isValidLength() should return false for short passwords.
     */
    public static void testShortPasswordLength() {
        String password = "abc";
        boolean valid = PasswordUtils.isValidLength(password);
        System.out.println("Test 5 - Short Password Length:");
        System.out.println("Expected: false");
        System.out.println("Actual:   " + valid);
        System.out.println(!valid ? "PASS\n" : "FAIL\n");
    }
}