<img align="left" width="64" height="64" src="https://raw.githubusercontent.com/wiki/PolyhedralDev/Terra/images/terra_logo.png" alt="Terra Logo">

# Terra

> **Fork custom (WIP) pour Paper 26.1.2**
>
> Ce dépôt est basé sur la branche `feat/26_1_2` de [ArikSquad/Terra](https://github.com/ArikSquad/Terra/tree/feat/26_1_2)
> (PR [PolyhedralDev/Terra#559](https://github.com/PolyhedralDev/Terra/pull/559), non mergée au moment du build,
> commit `47d4307`).
> Aucune release officielle de Terra ne supporte encore Bukkit/Paper 26.1.2 (dernière release officielle : 6.2.0-BETA, Bukkit 1.19).
>
> Build produit localement le 2026-08-16 avec Gradle 9.5.0 / JDK 25 :
> - Jar déployable : `dist/Terra-bukkit-7.0.0-BETA+ee6d582-shaded.jar` (bindings NMS `v26_1_2` inclus + addons core)
> - À régénérer : `./gradlew :platforms:bukkit:build` (JDK 25 requis, `platforms/bukkit/build/libs/`)
>
> **Risques** : code non mergé upstream, peut contenir des bugs ; PR maintenue par un contributeur tiers.
> À remplacer par une release officielle dès qu'elle supportera nativement 26.1.2.
>
> **IMPORTANT — mise à niveau depuis un ancien build dev (ex. 6.6.6-BETA+451683aff) :**
> videz `plugins/Terra/addons/` **et** `plugins/Terra/packs/` + `plugins/Terra/metapacks/` avant/après le remplacement
> du jar. Le mécanisme d'auto-remplacement de Terra ne supprime que les fichiers portant le même nom ; les anciens
> addons renommés (ex. `biome-provider-pipeline-v2@…451683aff`) restent et provoquent un
> `NoClassDefFoundError: com/dfsek/terra/api/noise/NoiseSampler` (package noise supprimé de l'API), et les anciens packs
> (ex. Overworld v1.5.2) provoquent `No such BaseAddon "biome-provider-pipeline-v2"` + `DuplicateEntryException
> "OVERWORLD:OVERWORLD"`. Ne gardez que `Overworld.zip`, `ReimagEND.zip`, `Tartarus.zip` dans `packs/` et `default.zip`
> dans `metapacks/` (aucun dossier étranger — `packs/` est scanné tel quel). En cas de doute, supprimez tout le dossier
> `plugins/Terra/` (sauvegardez vos packs/configs custom avant) et laissez Terra tout re-dumper depuis le jar.
>
> **Note (fix local)** : le fallback NMS de `createBlockState` contourne désormais le cache non thread-safe de
> `CraftBlockData` (cause de `IllegalArgumentException: Invalid block state data: minecraft:chain` en Paper 26.1.2).

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

