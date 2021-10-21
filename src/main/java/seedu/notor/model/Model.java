package seedu.notor.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.notor.commons.core.GuiSettings;
import seedu.notor.logic.parser.exceptions.ParseException;
import seedu.notor.model.group.Group;
import seedu.notor.model.group.SubGroup;
import seedu.notor.model.group.SuperGroup;
import seedu.notor.model.person.Person;

/**
 * The API of the Model component.
 */
public interface Model {
    /**
     * {@code Predicate} that always evaluate to true
     */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;

    // TODO: List
    // Predicate<Group> PREDICATE_SHOW_ALL_GROUPS = unused -> true;

    //=========== UserPrefs ==================================================================================

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getNotorFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setNotorFilePath(Path notorFilePath);

    //=========== Notor =====================================================================================

    /**
     * Replaces Notor data (of the list) with the data in {@code notor}.
     */
    void setNotor(ReadOnlyNotor notor);

    void clearNotorNote();

    /**
     * Returns the Notor data (lists and the like)
     */
    ReadOnlyNotor getNotor();

    /**
     * Returns true if a person with the same identity as {@code person} exists in Notor.
     */
    boolean hasPerson(Person person);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deletePerson(Person target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in Notor.
     */
    void createPerson(Person person);

    /**
     * Finds the given person.
     */
    Person findPerson(String name);

    /**
     * Returns true if the SuperGroup exist.
     */
    boolean hasSuperGroup(SuperGroup superGroup);

    void addSuperGroup(SuperGroup superGroup);

    void addSuperGroup(String superGroup) throws ParseException;

    void deleteSuperGroup(SuperGroup superGroup);

    Group findGroup(String name);

    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    void setPerson(Person target, Person editedPerson);

    /**
     * Returns an unmodifiable view of the filtered person list
     */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     *
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPersonList(Predicate<Person> predicate);

    /**
     * Returns an unmodifiable view of the filtered group list
     */
    ObservableList<SuperGroup> getFilteredGroupList();

    /**
     * Updates the filter of the filtered group list to filter by the given {@code predicate}.
     *
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredGroupList(Predicate<Group> predicate);

    /**
     * Returns an unmodifiable view of the filtered subgroup list
     */
    ObservableList<SubGroup> getFilteredSubGroupList();

    /**
     * Updates the filter of the filtered sybgroup list to filter by the given {@code predicate}.
     *
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredSubGroupList(Predicate<SubGroup> predicate);

    void deleteSubGroup(SubGroup subGroup);

    //=========== View Check =============================================================
    boolean isPersonView();

    boolean isGroupView();

    boolean isSubGroupView();
}
