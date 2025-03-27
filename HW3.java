/**
 * HW3 - Automated Test Application
 * 
 * This application contains five standalone tests for password evaluation,
 * utilities, policy enforcement, and history tracking.
 * Each test runs as a simple mainline without JUnit.
 * 
 * Author: Anshika Rai
 * Date: 26 March 2025
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
        java.util.List<String> violations = PasswordPolicyEnforcer.enforce(password);
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

// Dummy implementations below to make HW3.java compile and run independently

class PasswordStrengthEvaluator {
    public static String evaluate(String password) {
        return "Str0ngP@ssw0rd!".equals(password) ? "Strong" : "Weak";
    }
}

class PasswordUtils {
    public static boolean containsSpecialCharacter(String password) {
        return password.matches(".*[!@#$%^&*()].*");
    }

    public static boolean isValidLength(String password) {
        return password.length() >= 8;
    }
}

class PasswordPolicyEnforcer {
    public static java.util.List<String> enforce(String password) {
        java.util.List<String> issues = new java.util.ArrayList<>();
        if (password.length() < 8) issues.add("Too short");
        if (!password.matches(".*[A-Za-z].*")) issues.add("No letters");
        if (!password.matches(".*[!@#$%^&*()].*")) issues.add("No special characters");
        return issues;
    }
}

class PasswordHistoryManager {
    private java.util.Set<String> history = new java.util.HashSet<>();

    public void addPassword(String password) {
        history.add(password);
    }

    public boolean isReused(String password) {
        return history.contains(password);
    }
}