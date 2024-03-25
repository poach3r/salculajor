Salculajor is simple cross-platform calculator written in Java.

Sejit is a simple cross-platform text editor written in Java.

![demo](demo.png)

# Usage

`java -jar ./salculajor.jar`

# Configuration

Salculajor will first look for the configuration defined by the `SALCULAJOR_CONFIG` environment
variable, if none is found it will look for `~/.config/salculajor/config.toml`, if no valid
configs are found, the default values are used and a warning is printed to the console.

A sample config.toml file has been provided in this repo.