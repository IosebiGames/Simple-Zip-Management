# Simple-Zip-Management
a simple code which lets you create, extract, remove content of the Zip file.

# HOW TO USE IT:
- first you need to create instance of ZipManager class ( ZipManager zm = new ZipManager(); )
- Then you need to name your Zip file anything, just insert a path: ( ZipManager zm = new ZipManager("myZip.zip"); )
- Now you can call different methods from ZipManager class (add(), extractZip(), removeFile(); )

# What Each of them does:
add("/content file path");\
Explanation: adds file content inside of Zip file after its been created\
extractZip("/content file path", "/destionationPath");\
Explanation: extracts specific content from the Zip file into certain package\
removeFile("/content file path");\
Explanation: removes specific content from the Zip file\

Note: setPassword method is malfunctioning for some reason, performing it results nothing. everything is working but no password is setting at all.
