<p align="center">
  <img src="https://i.imgur.com/qDxlBr4.png" width="300" />
</p>

# Automated Information Privacy Risk Assessment Tool (AIPRAT)

How and to what degree can the information privacy risk assessment of mHealth apps be automated?

## Installation

### Dependencies

```
pip install -r requirements.txt
```

### Setup

Create file in path ```/decompiler/libs/googleplay-api/config.py``` with the following content

```python
# separator used by search.py, categories.py, ...
SEPARATOR = ";"

LANG            = "en_US" # can be en_US, fr_FR, ...
ANDROID_ID      = "" # "xxxxxxxxxxxxxxxx"
GOOGLE_LOGIN    = "" # "username@gmail.com"
GOOGLE_PASSWORD = ""
AUTH_TOKEN      = None # "yyyyyyyyy"

# force the user to edit this file
if any([each == None for each in [ANDROID_ID, GOOGLE_LOGIN, GOOGLE_PASSWORD]]):
    raise Exception("config.py not updated")
```

The ANDROID_ID is the unique ID of a real Android hardware device. This is used to download the apps from the Google PlayStore.

## Credits

* https://github.com/egirault/googleplay-api
