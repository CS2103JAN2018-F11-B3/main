package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SALARY_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SALARY_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.internship.Internship;
import seedu.address.model.internship.exceptions.DuplicateInternshipException;

/**
 * A utility class containing a list of {@code Internship} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Internship ALICE = new PersonBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withSalary("85355255")
            .withTags("friends").build();
    public static final Internship BENSON = new PersonBuilder().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com").withSalary("98765432")
            .withTags("owesMoney", "friends").build();
    public static final Internship CARL = new PersonBuilder().withName("Carl Kurz").withSalary("95352563")
            .withEmail("heinz@example.com").withAddress("wall street").build();
    public static final Internship DANIEL = new PersonBuilder().withName("Daniel Meier").withSalary("87652533")
            .withEmail("cornelia@example.com").withAddress("10th street").build();
    public static final Internship ELLE = new PersonBuilder().withName("Elle Meyer").withSalary("9482224")
            .withEmail("werner@example.com").withAddress("michegan ave").build();
    public static final Internship FIONA = new PersonBuilder().withName("Fiona Kunz").withSalary("9482427")
            .withEmail("lydia@example.com").withAddress("little tokyo").build();
    public static final Internship GEORGE = new PersonBuilder().withName("George Best").withSalary("9482442")
            .withEmail("anna@example.com").withAddress("4th street").build();

    // Manually added
    public static final Internship HOON = new PersonBuilder().withName("Hoon Meier").withSalary("8482424")
            .withEmail("stefan@example.com").withAddress("little india").build();
    public static final Internship IDA = new PersonBuilder().withName("Ida Mueller").withSalary("8482131")
            .withEmail("hans@example.com").withAddress("chicago ave").build();

    // Manually added - Internship's details found in {@code CommandTestUtil}
    public static final Internship AMY = new PersonBuilder().withName(VALID_NAME_AMY).withSalary(VALID_SALARY_AMY)
            .withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY).withTags(VALID_TAG_FRIEND).build();
    public static final Internship BOB = new PersonBuilder().withName(VALID_NAME_BOB).withSalary(VALID_SALARY_BOB)
            .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Internship internship : getTypicalPersons()) {
            try {
                ab.addInternship(internship);
            } catch (DuplicateInternshipException e) {
                throw new AssertionError("not possible");
            }
        }
        return ab;
    }

    public static List<Internship> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
