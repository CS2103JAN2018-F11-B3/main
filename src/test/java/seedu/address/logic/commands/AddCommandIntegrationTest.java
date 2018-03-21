package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.Before;
import org.junit.Test;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.UndoRedoStack;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.internship.Internship;
import seedu.address.testutil.PersonBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code AddCommand}.
 */
public class AddCommandIntegrationTest {

    private Model model;

    @Before
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_newPerson_success() throws Exception {
        Internship validInternship = new PersonBuilder().build();

        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.addPerson(validInternship);

        assertCommandSuccess(prepareCommand(validInternship, model), model,
                String.format(AddCommand.MESSAGE_SUCCESS, validInternship), expectedModel);
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        Internship internshipInList = model.getAddressBook().getPersonList().get(0);
        assertCommandFailure(prepareCommand(internshipInList, model), model, AddCommand.MESSAGE_DUPLICATE_PERSON);
    }

    /**
     * Generates a new {@code AddCommand} which upon execution, adds {@code internship} into the {@code model}.
     */
    private AddCommand prepareCommand(Internship internship, Model model) {
        AddCommand command = new AddCommand(internship);
        command.setData(model, new CommandHistory(), new UndoRedoStack());
        return command;
    }
}
