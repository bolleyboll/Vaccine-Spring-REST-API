# Vaccine

CLINICAL VACCINE TRIAL

1) HOME PAGE(/)

* Navbar: Organization, Vaccine, About Us				Search, Login, Sign up.
* Body: Results of vaccine trial --> Onclick leads to the Vaccine's details, Logos of Organization.
* Footer: Contact Us, help, articles etc..

2) Login(/login)

* Login form.
* We have different tabs for organization and patient login.

3) Organization(/org) || (/org/:username)

* Navbar: Organization, Vaccine, Logout, About Us			Search, Edit Profile.
* Every organization can edit its profile.
* They have Start-new-Trial button.
* The organization can select the patients for trail, based on their symptoms.
* Organization contains information about the vaccine, its working on along with its report.
* The organization can also add and remove vaccine.

4) Patients(/patient) || (/patient/:username)

* Navbar: Organization, Vaccine, About Us			Search, Enroll(/enroll) button should be disabled if already enrolled, Medical Remarks(we have this in DB), EditProfile, Logout. 
* They can edit their profile.
* They can enroll in test.
* they can see their test result.

## Routes

/login: 
/register: 

/org: 
/org/profile: 
/org/profile/edit: 
/org/delete:
/org/vaccine:
/org/vaccine/add:
/org/vaccine/delete:
/org/vaccine/edit:
/org/trials:
/org/newtrial:

/patient: 
/patient/profile: 
/patient/profile/edit: 
/patient/delete:
/patient/results:
/patient/enroll: 

/forgotpassword
/logout
/about

## Route Description

/login: 
*accepts username, password, type(org/patient)
*does authentication 
*returns success or failure 
*returns to homepage else /login

/register: 
*accepts info, type (org/patient)
*does registration, checks if user is already registered or not
*returns success or failure
*returns to /login else /register with alert msg

/org: 
*accepts: NIL
*does: list of all organizations which are registered
*returns: list of all organizations which are registered
*returns to: ListOrg

/org/profile: 
*accepts: NIL
*does: displays profile details
*returns: profile details
*returns to: profileComponent

/org/profile/edit: 
*accepts: form with user details
*does: changes user profile
*returns: success or failure
*returns to: EditProfileCoomponent

/org/delete:
*accepts: orgId
*does: checks password to delete and deletes the org
*returns: 
*returns to: 

/org/vaccine:
*accepts:
*does: 
*returns: 
*returns to:

/org/vaccine/add:
*accepts:
*does: 
*returns: 
*returns to:

/org/vaccine/delete:
*accepts:
*does: 
*returns: 
*returns to:

/org/vaccine/edit:
*accepts:
*does: 
*returns: 
*returns to:

/org/trials:
*accepts:
*does: 
*returns: 
*returns to:

/org/newtrial:
*accepts:
*does: 
*returns: 
*returns to:


/patient: 
*accepts:
*does: 
*returns: 
*returns to:

/patient/profile: 
*accepts:
*does: 
*returns: 
*returns to:

/patient/profile/edit: 
*accepts:
*does: 
*returns: 
*returns to:

/patient/delete:
*accepts:
*does: 
*returns: 
*returns to:

/patient/results:
*accepts:
*does: 
*returns: 
*returns to:

/patient/enroll: 
*accepts:
*does: 
*returns: 
*returns to:


/forgotpassword
*accepts:
*does: 
*returns: 
*returns to:

/logout
*accepts:
*does: 
*returns: 
*returns to:

/about
*accepts:
*does: 
*returns: 
*returns to: