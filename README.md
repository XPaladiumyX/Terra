<img align="left" width="64" height="64" src="https://raw.githubusercontent.com/wiki/PolyhedralDev/Terra/images/terra_logo.png" alt="Terra Logo">

# Terra

> **SkyXNetwork custom fork (WIP) for Paper 26.1.2**
>
> ⚠️ **This is a special fork made to run on SkyXNetwork servers.**
> Using this custom build on any other server is **at your own risk** — SkyXNetwork is **not responsible**
> for any damage, data loss or instability caused by this plugin.
>
> This repository is based on the `feat/26_1_2` branch of [ArikSquad/Terra](https://github.com/ArikSquad/Terra/tree/feat/26_1_2)
> (PR [PolyhedralDev/Terra#559](https://github.com/PolyhedralDev/Terra/pull/559), unmerged at build time,
> commit `47d4307`).
> No official Terra release supports Bukkit/Paper 26.1.2 yet (latest official release: 6.2.0-BETA, Bukkit 1.19).
>
> Built locally on 2026-08-16 with Gradle 9.5.0 / JDK 25:
> - Deployable jar: `dist/Terra-bukkit-7.0.0-BETA+ee6d582-shaded.jar` (includes NMS bindings `v26_1_2` + core addons)
> - To rebuild: `./gradlew :platforms:bukkit:build` (JDK 25 required, output in `platforms/bukkit/build/libs/`)
>
> **Risks**: unmerged upstream code, may contain bugs; PR maintained by a third-party contributor.
> Replace with an official release as soon as one natively supports 26.1.2.
>
> **IMPORTANT — upgrading from an older dev build (e.g. 6.6.6-BETA+451683aff):**
> empty `plugins/Terra/addons/` **and** `plugins/Terra/packs/` + `plugins/Terra/metapacks/` before/after replacing
> the jar. Terra's auto-replacement only removes files with the same name; leftover renamed addons
> (e.g. `biome-provider-pipeline-v2@…451683aff`) cause
> `NoClassDefFoundError: com/dfsek/terra/api/noise/NoiseSampler` (noise package removed from the API), and leftover
> packs (e.g. Overworld v1.5.2) cause `No such BaseAddon "biome-provider-pipeline-v2"` +
> `DuplicateEntryException "OVERWORLD:OVERWORLD"`. Keep only `Overworld.zip`, `ReimagEND.zip`, `Tartarus.zip` in
> `packs/` and `default.zip` in `metapacks/` (no foreign folders — `packs/` is scanned as-is). When in doubt, delete
> the whole `plugins/Terra/` folder (back up your custom packs/configs first) and let Terra re-dump everything from
> the jar.
>
> **Local fix note**: the NMS `createBlockState` fallback now bypasses the non-thread-safe `CraftBlockData` cache
> (cause of `IllegalArgumentException: Invalid block state data: minecraft:chain` on Paper 26.1.2).

Terra is a modern world generation modding platform, primarily for Minecraft.
Terra allows complete customization of world generation with an advanced API,
tightly integrated with a powerful configuration system.

Terra consists of several parts:

* A voxel world generation API with emphasis on configuration and extensibility
* Several platform implementations, the layer between the API and the platform
  it's running on.
* An addon loader, which allows addons to interface with the Terra API in a
  platform-agnostic setting
* Several "core addons," which implement the "default" configurations of Terra.
  These addons can be thought of as the config "standard library"

Terra currently officially supports the Fabric mod loader and the Bukkit API
(Paper and friends). We welcome Pull Requests implementing additional platforms!

## Downloads:

* Fabric: [Modrinth](https://modrinth.com/mod/terra)
  / [CurseForge](https://www.curseforge.com/minecraft/mc-mods/terra-world-generator)
* Paper+ servers (Paper, Tuinity, Purpur,
  etc): [SpigotMC](https://www.spigotmc.org/resources/85151/)

## Building and Running Terra

To build, simply run `./gradlew build` (`gradlew.bat build` on Windows). This
will build all platforms, and produce JARs in `platforms/<platform>/build/libs`

### Production JARs:

* Bukkit: `Terra-<version>-shaded.jar`
* Fabric: `Terra-<version>-shaded-mapped.jar`

### Building a Specific Platform

To build a specific platform, run `gradlew :platforms:<platform>:build`.

JARs are produced in `platforms/<platform>/build/libs`.

### Running Minecraft in the IDE

To run Minecraft with Terra in the IDE (for testing) use the following tasks:

* Bukkit
    * `runServer` - Run the Paper test server with Terra installed.
* Fabric
    * `runClient` - Run a Minecraft Fabric client with Terra installed.
    * `runServer` - Run a Minecraft Fabric server with Terra installed.

## Contributing

Contributions are welcome! If you want to see a feature in Terra, please, open
an issue, or implement it yourself and submit a PR!
Join the discord [here](https://discord.gg/PXUEbbF) if you would like to talk
more about the project!

## Licensing

Parts of Terra are licensed under either the MIT License or the GNU General
Public License, version 3.0.

* Our API is licensed under the [MIT License](LICENSE), to ensure that everyone
  is able to freely use it however they want.
* Our core addons are also licensed under the [MIT License](LICENSE), to ensure
  that people can freely use code from them to learn and make their own addons,
  without worrying about GPL infection.
* Our platform-agnostic implementations and platform implementations are
  licensed under
  the [GNU General Public License, version 3.0](common/implementation/LICENSE),
  to ensure that they remain free software wherever they are used.

If you're not sure which license a particular file is under, check:

* The file's header
* The LICENSE file in the closest parent folder of the file in question

## Beta

Terra is still in beta! While it is stable, it is not feature-complete. There is
a lot to be added!

## Special Thanks

[![YourKit-Logo](https://www.yourkit.com/images/yklogo.png)](https://www.yourkit.com/)

YourKit has granted Polyhedral Development an open-source license to their
outstanding Java profiler, allowing us to make our software as performant as it
can be!

YourKit supports open source projects with innovative and intelligent tools for
monitoring and profiling Java and .NET applications. YourKit is the creator of
the
[YourKit Java Profiler](https://www.yourkit.com/java/profiler/),
[YourKit .NET Profiler](https://www.yourkit.com/.net/profiler/),
and [YourKit YouMonitor](https://www.yourkit.com/youmonitor/).

