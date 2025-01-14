The channel `format` defines how messages sent on that channel will be formatted. The content of the message sent by the player itself is always appended after the formatting. Note that any uncleared formatting will persist and apply to the message contents. The format of private messages, group private messages and broadcasts can also be customised.

## MineDown
You can make use of [MineDown formatting](https://github.com/Phoenix616/MineDown) to use modern (1.16+) hexadecimal colors and easily
make use of advanced text effects such as gradients. You can embed this formatting within the prefix and suffix contents of LuckPerms groups as well.

## Placeholders
Within channel formats you can make use of the following placeholders, which will be replaced with the formatted text. Please note PlaceholderAPI placeholders are not supported, as PlaceholderAPI is a backend (Spigot) plugin and does not run on the proxy layer.

### Regular placeholders
* `%name%` - Username
* `%fullname%` - LuckPerms prefix, username & LuckPerms suffix
* `%prefix%` - LuckPerms prefix
* `%suffix%` - LuckPerms suffix
* `%ping%` - User's ping
* `%uuid%` - User's uuid
* `%servername%` - Server the user is on
* `%serverplayercount%` - Number of players on the server the user is on

### Time placeholders
These display the current system time.
* `%timestamp%` - yyyy/MM/dd HH:mm:ss
* `%time%` - HH:mm:ss
* `%short_time%` - HH:mm
* `%date%` - yyyy/MM/dd
* `%british_date%` - dd/MM/yyyy
* `%day%` - dd
* `%month%` - MM
* `%year%` - yyyy

### Private message placeholders
In private messages, the placeholders are applied to the sender of the message for inbound messages, and the receiver for outbound messages. You can use all placeholders above after the `sender_` or `receiver_` prefix. (e.g. `%sender_(placeholder)%` and `%receiver_(placeholder)%`).

There are additional placeholders for group private messages:
* `%group_amount%` (number of members in the group private message)
* `%group_amount_subscript%` (number of members in the group private message, in subscript font)
* `%group_members_comma_separated%` (comma separated list of members in the group private message)
* `%group_members%` (newline separated list of members in the group private message)

The social spy message formatting lets you format both the message sender and receiver with the same placeholders listed above. The sender and receiver are disambiguated with prefixes, so you can use both; i.e. `%sender_(placeholder)%` and `%receiver_(placeholder)%`.