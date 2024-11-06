

// the file has to be in the root directory of the module (src direcotry in this case
// It should use the keyword module instead of class, interface, enum
// The module name follows the naming rules for package names. It often includes periods (.) in its
//name. Regular class and package names are not allowed to have dashes (-). Module names follow the
//same rule.

module zoo.animal.module {
    exports zoo.animal.feeding;
}